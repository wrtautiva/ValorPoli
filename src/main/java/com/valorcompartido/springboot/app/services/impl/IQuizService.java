package com.valorcompartido.springboot.app.services.impl;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.core.exceptions.enums.LogRefServices;
import com.valorcompartido.springboot.app.core.exceptions.persistence.DataNotFoundPersistenceException;
import com.valorcompartido.springboot.app.core.exceptions.service.DataNotFoundServiceException;
import com.valorcompartido.springboot.app.daos.QuizDAO;
import com.valorcompartido.springboot.app.model.dto.ModuloDTO;
import com.valorcompartido.springboot.app.model.entity.ModuloEntity;
import com.valorcompartido.springboot.app.model.entity.QuizEntity;
import com.valorcompartido.springboot.app.model.dto.QuizDTO;
import com.valorcompartido.springboot.app.services.ModuloService;
import com.valorcompartido.springboot.app.services.QuizService;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IQuizService implements QuizService {

    private final QuizDAO quizDAO;
    private final ModuloService service;

    public IQuizService(QuizDAO quizDAO, ModuloService service) {

        this.quizDAO = quizDAO;
        this.service = service;
    }

    @Override
    public List<QuizDTO> listarQuiz() throws ServiceException {

        try {
            List<QuizEntity> listSub = Optional.of(quizDAO.findAll())
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperQuizEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public QuizDTO findQuizById(Integer Id) throws ServiceException {
        try{
            return Optional.ofNullable(quizDAO.findQuizEntityBy(Id)).map(this::mapperQuizEntityDTO)
                    .orElseThrow(() -> new DataNotFoundServiceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO,"Dato no encontrado por el ID"));
        }catch(IllegalArgumentException | PersistenceException pe){
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO,"Dato no encontrado por el ID");
        }catch(Exception e){
            throw  new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO,"Error general en el servicio",e);
        }

    }

    @Override
    public QuizEntity findQuizEntityById(Integer id) throws ServiceException {
        try {
            return Optional.ofNullable(quizDAO.findQuizEntityBy(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public List<QuizDTO> findQuizByIdModulo(Integer id) throws ServiceException {
        try{
            List<QuizEntity> listSub = Optional.of(quizDAO.findQuizByIdModulo(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperQuizEntityDTO).collect(Collectors.toList());
        }catch(IllegalArgumentException | PersistenceException pe){
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO,"Dato no encontrado por el ID");
        }catch(Exception e){
            throw  new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO,"Error general en el servicio",e);
        }
    }

    @Override
    public List<QuizDTO> findQuizByTitulo(String titulo) throws ServiceException {
        try{
            List<QuizEntity> listSub = Optional.of(quizDAO.findQuizByTitulo(titulo))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperQuizEntityDTO).collect(Collectors.toList());
        }catch(IllegalArgumentException | PersistenceException pe){
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO,"Dato no encontrado por el ID");
        }catch(Exception e){
            throw  new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO,"Error general en el servicio",e);
        }

    }

    @Override
    public QuizDTO create(QuizDTO quizDTO) throws ServiceException {

        try {
            return mapperQuizEntityDTO(quizDAO.save(mapperQuizDTOEntity(quizDTO)));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "eror al crear el usuario" + quizDTO, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public QuizEntity update(QuizDTO quizDTO) throws ServiceException {

        try {
            QuizEntity quizActual= quizDAO.findQuizEntityBy(quizDTO.getIdQuiz());
            quizActual.setTitulo (quizDTO.getTitulo());
            quizActual.setDescripcion (quizDTO.getDescripcion());
            return quizDAO.save(quizActual);
        }catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "error al actualizar el Quiz" , pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try{
            quizDAO.deleteById(id);
        }catch(IllegalArgumentException | PersistenceException pe){
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "error al borrar el usuario" , pe);
        }catch (Exception e){
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public QuizEntity disable(QuizDTO quizDTO) throws ServiceException {
        try{
            QuizEntity quizActual = mapperQuizDTOEntity(findQuizById(quizDTO.getIdQuiz()));
            quizActual.setEstado(quizActual.getEstado());
            quizDAO.save(quizActual);
            return quizActual;
        }
        catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "error al actualizar el Quiz" , pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    /*
    Mappers
     */
    //De entity a DTO
    public QuizDTO mapperQuizEntityDTO(QuizEntity quizEntity){
        return QuizDTO.builder().
                titulo(quizEntity.getTitulo())
                .descripcion(quizEntity.getDescripcion())
                .moduloIdModulo(new ModuloDTO(
                        quizEntity.getModuloByModuloIdModulo().getIdModulo(),
                        quizEntity.getModuloByModuloIdModulo().getTitulo(),
                        quizEntity.getModuloByModuloIdModulo().getFechaCreacion(),
                        quizEntity.getModuloByModuloIdModulo().getEstado()))
                .estado(quizEntity.getEstado())
                .build();
    }
    //De DTO a entidad
    public QuizEntity mapperQuizDTOEntity(QuizDTO quizDTO) throws ServiceException {

        QuizEntity quiz = new QuizEntity();
        ModuloEntity modulo  = service.findModuloEntityById(quizDTO.getModuloIdModulo().getIdModulo());//Get del DTO
        quiz.setTitulo(quizDTO.getTitulo());
        quiz.setDescripcion(quizDTO.getDescripcion());
        quiz.setEstado(quizDTO.getEstado());
        quiz.setModuloByModuloIdModulo(modulo);//Inserta el objeto quiz set entitido para insertar todo el objeto
        return quiz;
    }
}
