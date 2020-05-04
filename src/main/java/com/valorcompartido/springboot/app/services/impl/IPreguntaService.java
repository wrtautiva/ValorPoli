package com.valorcompartido.springboot.app.services.impl;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.core.exceptions.enums.LogRefServices;
import com.valorcompartido.springboot.app.core.exceptions.persistence.DataNotFoundPersistenceException;
import com.valorcompartido.springboot.app.daos.PreguntaDAO;
import com.valorcompartido.springboot.app.daos.QuizDAO;
import com.valorcompartido.springboot.app.model.dto.PreguntaDTO;
import com.valorcompartido.springboot.app.model.dto.QuizDTO;
import com.valorcompartido.springboot.app.model.emuns.TipoPregunta;
import com.valorcompartido.springboot.app.model.entity.PreguntaEntity;
import com.valorcompartido.springboot.app.model.entity.QuizEntity;
import com.valorcompartido.springboot.app.services.PreguntaService;
import com.valorcompartido.springboot.app.services.QuizService;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IPreguntaService implements PreguntaService {

    private final PreguntaDAO preguntaDAO;
    private final QuizService quizService;

    public IPreguntaService(PreguntaDAO preguntaDAO,QuizService quizService) {
        this.preguntaDAO = preguntaDAO;
        this.quizService = quizService;
    }


    @Override
    public List<PreguntaDTO> listaPregunta() throws ServiceException {
        try {
            List<PreguntaEntity> listSub = Optional.of(preguntaDAO.findAll())
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperPreguntaEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public PreguntaDTO findPreguntaById(Integer id) throws ServiceException {
        try {
            return Optional.of(preguntaDAO.finPreguntaEntityById(id)).map(this::mapperPreguntaEntityDTO)
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }

    }

    @Override
    public PreguntaEntity findPreguntaEntityById(Integer id) throws ServiceException {
        try {
            return Optional.ofNullable(preguntaDAO.finPreguntaEntityById(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public List<PreguntaDTO> finPreguntaByIdQuiz(Integer id) throws ServiceException {
        try {
            List<PreguntaEntity> listSub = Optional.of(preguntaDAO.finPreguntaByIdQuiz(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperPreguntaEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public PreguntaDTO create(PreguntaDTO preguntaDTO) throws ServiceException {
        try {
            return mapperPreguntaEntityDTO(preguntaDAO.save(mapperPreguntaDTOEntity(preguntaDTO)));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "eror al crear el usuario" + preguntaDTO, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public PreguntaEntity update(PreguntaDTO preguntaDTO) throws ServiceException {
        try {
            PreguntaEntity preguntaActual = preguntaDAO.finPreguntaEntityById(preguntaDTO.getIdPregunta());
            preguntaActual.setTitulo(preguntaDTO.getTitulo());
            return preguntaDAO.save(preguntaActual);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "eror al crear la subcategoria", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try {
            preguntaDAO.deleteById(id);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public PreguntaEntity disable(PreguntaDTO preguntaDTO) throws ServiceException {
        try {
            PreguntaEntity preguntaActual = mapperPreguntaDTOEntity(findPreguntaById(preguntaDTO.getIdPregunta()));
            preguntaActual.setTitulo(preguntaDTO.getTitulo());
            return preguntaDAO.save(preguntaActual);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "error al actualizar el Quiz", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public List<PreguntaDTO> findByTitleLike(String titulo) throws ServiceException {
        try {
            List<PreguntaEntity> listSub = Optional.of(preguntaDAO.findByTitleLike(titulo))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));

            return listSub.stream().map(this::mapperPreguntaEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el documento", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    /*
  Mappers
   */
    //De entity a DTO
    public PreguntaDTO mapperPreguntaEntityDTO(PreguntaEntity PreguntaEntity){
        return PreguntaDTO.builder().
                titulo(PreguntaEntity.getTitulo())
                .tipoPregunta(PreguntaEntity.getTipoPregunta())
                .QuizIdQuiz(new QuizDTO(PreguntaEntity.getQuizByQuizIdQuiz().getIdQuiz(),
                        PreguntaEntity.getQuizByQuizIdQuiz().getTitulo(),
                        PreguntaEntity.getQuizByQuizIdQuiz().getDescripcion()))
                .build();
    }


    //De DTO a entidad
    public PreguntaEntity mapperPreguntaDTOEntity(PreguntaDTO preguntaDTO) throws ServiceException {

        PreguntaEntity pregunta = new PreguntaEntity();
        QuizEntity quiz = quizService.findQuizEntityById(preguntaDTO.getQuizIdQuiz().getIdQuiz());//Get del DTO
        pregunta.setTipoPregunta(preguntaDTO.getTipoPregunta());
        pregunta.setTitulo(preguntaDTO.getTitulo());
        pregunta.setTipoPregunta(TipoPregunta.CERRADA);
        pregunta.setQuizByQuizIdQuiz(quiz);//Inserta el objeto quiz set entitido para insertar todo el objeto
        return pregunta;
    }
}
