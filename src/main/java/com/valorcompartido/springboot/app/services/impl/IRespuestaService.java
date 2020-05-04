package com.valorcompartido.springboot.app.services.impl;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.core.exceptions.enums.LogRefServices;
import com.valorcompartido.springboot.app.core.exceptions.persistence.DataNotFoundPersistenceException;
import com.valorcompartido.springboot.app.daos.RespuestaDAO;
import com.valorcompartido.springboot.app.model.dto.PreguntaDTO;
import com.valorcompartido.springboot.app.model.dto.RespuestaDTO;
import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.entity.PreguntaEntity;
import com.valorcompartido.springboot.app.model.entity.RespuestaEntity;
import com.valorcompartido.springboot.app.services.PreguntaService;
import com.valorcompartido.springboot.app.services.RespuestaService;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IRespuestaService implements RespuestaService {

    private final RespuestaDAO respuestaDAO;
    private final PreguntaService preguntaService;

    public IRespuestaService(RespuestaDAO respuestaDAO, PreguntaService preguntaService) {
        this.respuestaDAO = respuestaDAO;
        this.preguntaService = preguntaService;
    }


    @Override
    public List<RespuestaDTO> listaRespuesta() throws ServiceException {
        try {
            List<RespuestaEntity> listSub = Optional.of(respuestaDAO.findAll())
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperRespuestaEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public RespuestaDTO findRespuestaById(Integer id) throws ServiceException {
        try {
            return Optional.ofNullable(respuestaDAO.findRespuestaEntityById(id)).map(this::mapperRespuestaEntityDTO)
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public RespuestaEntity findRespuestaEntityById(Integer id) throws ServiceException {
        try {
            return Optional.ofNullable(respuestaDAO.findRespuestaEntityById(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public RespuestaDTO create(RespuestaDTO respuestaDTO) throws ServiceException {
        try {
            return mapperRespuestaEntityDTO(respuestaDAO.save(mapperRespuestaDTOEntity(respuestaDTO)));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "eror al crear el usuario" + respuestaDTO, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public RespuestaEntity update(RespuestaDTO respuestaDTO) throws ServiceException {
        try {
            RespuestaEntity repuestaActual = respuestaDAO.findRespuestaEntityById(respuestaDTO.getIdRespuesta());
            repuestaActual.setRespuesta(respuestaDTO.getRespuesta());
            repuestaActual.setCorrecta(respuestaDTO.getEstado());
            return respuestaDAO.save(repuestaActual);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "eror al crear la subcategoria", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try {
            respuestaDAO.deleteById(id);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public RespuestaEntity changeCorrect(RespuestaDTO respuestaDTO) throws ServiceException {
        try {
            RespuestaEntity respuestaActual = mapperRespuestaDTOEntity(findRespuestaById(respuestaDTO.getIdRespuesta()));
            respuestaActual.setCorrecta(respuestaDTO.getEstado());
            return respuestaDAO.save(respuestaActual);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "error al actualizar el Quiz", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public List<RespuestaDTO> findByTitleLike(String titulo) throws ServiceException {

        try {
            List<RespuestaEntity> listSub = Optional.ofNullable(respuestaDAO.findByRespuestaLike(titulo.toUpperCase()))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));

            return listSub.stream().map(this::mapperRespuestaEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el documento", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }


   @Override
    public List<RespuestaDTO> findRespuestaByPregunta(Integer id) throws ServiceException {

        try {
            List<RespuestaEntity> listSub = Optional.ofNullable(respuestaDAO.findRespuestaEntityByPregunta(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperRespuestaEntityDTO).collect(Collectors.toList());
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
    public RespuestaDTO mapperRespuestaEntityDTO(RespuestaEntity respuestaEntity){

        return RespuestaDTO.builder().
                respuesta(respuestaEntity.getRespuesta())
                .estado(respuestaEntity.getCorrecta())
                .preguntaIdPregunta(new PreguntaDTO(
                        respuestaEntity.getPreguntaByPreguntaIdPregunta().getIdPregunta(),
                        respuestaEntity.getPreguntaByPreguntaIdPregunta().getTitulo()
                ))
                .build();
    }

    public RespuestaEntity mapperRespuestaDTOEntity(RespuestaDTO respuestaDTO) throws ServiceException {

        RespuestaEntity respuestaEntity = new RespuestaEntity();
        PreguntaEntity preguntaEntity = preguntaService.findPreguntaEntityById(respuestaDTO.getPreguntaIdPregunta().getIdPregunta());
        respuestaEntity.setRespuesta(respuestaDTO.getRespuesta().toUpperCase());
        respuestaEntity.setCorrecta(Estado.CORRECTA);
        respuestaEntity.setPreguntaByPreguntaIdPregunta(preguntaEntity);
        return respuestaEntity;
    }
}
