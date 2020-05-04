package com.valorcompartido.springboot.app.services.impl;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.core.exceptions.enums.LogRefServices;
import com.valorcompartido.springboot.app.core.exceptions.persistence.DataNotFoundPersistenceException;
import com.valorcompartido.springboot.app.core.util.Util;
import com.valorcompartido.springboot.app.daos.IntentoUsuarioDAO;
import com.valorcompartido.springboot.app.model.dto.IntentoUsuarioDTO;
import com.valorcompartido.springboot.app.model.dto.PreguntaDTO;
import com.valorcompartido.springboot.app.model.dto.RespuestaDTO;
import com.valorcompartido.springboot.app.model.dto.UsuarioDTO;
import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.entity.*;
import com.valorcompartido.springboot.app.services.IntentoUsuarioService;
import com.valorcompartido.springboot.app.services.PreguntaService;
import com.valorcompartido.springboot.app.services.RespuestaService;
import com.valorcompartido.springboot.app.services.UsuarioServiceJP;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IIntentoUsuarioService implements IntentoUsuarioService {

    private final IntentoUsuarioDAO intentoUsuarioDAO;
    private final UsuarioServiceJP usuarioService;
    private final PreguntaService preguntaService;
    private final RespuestaService respuestaService;
    private final Util util;

    public IIntentoUsuarioService(IntentoUsuarioDAO intentoUsuarioDAO, UsuarioServiceJP usuarioService, PreguntaService preguntaService, RespuestaService respuestaService, Util util) {
        this.intentoUsuarioDAO = intentoUsuarioDAO;
        this.usuarioService = usuarioService;
        this.preguntaService = preguntaService;
        this.respuestaService = respuestaService;
        this.util = util;
    }

    @Override
    public List<IntentoUsuarioDTO> listaIntentoUsuario() throws ServiceException {
        try {
            List<IntentoUsuarioEntity> listSub = Optional.of(intentoUsuarioDAO.findAll())
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperIntentoUsuarioEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public IntentoUsuarioDTO findIntentoUsuarioById(Integer id) throws ServiceException {
        try {
            return Optional.ofNullable(intentoUsuarioDAO.findIntentoUsuarioEntitiesById(id)).map(this::mapperIntentoUsuarioEntityDTO)
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public List<IntentoUsuarioDTO> findIntentoUsuarioByIdUsuario(Integer id) throws ServiceException {
        try {
            List<IntentoUsuarioEntity> listSub = Optional.ofNullable(intentoUsuarioDAO.findIntentoUsuarioEntitiesByIdUsuario(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperIntentoUsuarioEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public List<IntentoUsuarioDTO> findIntentoUsuarioEntitiesByIdPregunta(Integer id) throws ServiceException {
        try {
            List<IntentoUsuarioEntity> listSub = Optional.ofNullable(intentoUsuarioDAO.findIntentoUsuarioEntitiesByIdPregunta(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperIntentoUsuarioEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public List<IntentoUsuarioDTO> findIntentoUsuarioByCorrect(Estado correcta) throws ServiceException {
        try {
            List<IntentoUsuarioEntity> listSub = Optional.ofNullable(intentoUsuarioDAO.findIntentoUsuarioByCorrect(correcta))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperIntentoUsuarioEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public IntentoUsuarioDTO create(IntentoUsuarioDTO intentoUsuarioDTO) throws ServiceException {
        try {
            return mapperIntentoUsuarioEntityDTO(intentoUsuarioDAO.save(mapperIntentoUsuarioDTOEntity(intentoUsuarioDTO)));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Error al crear respuesta de usuario" + intentoUsuarioDTO, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public IntentoUsuarioEntity update(IntentoUsuarioDTO intentoUsuarioDTO) throws ServiceException {
        try {
            IntentoUsuarioEntity intentoUsuario = intentoUsuarioDAO.findIntentoUsuarioEntitiesById(intentoUsuarioDTO.getIdIntento_usuario());
            intentoUsuario.setCorrecta(intentoUsuarioDTO.getEstado());
            return intentoUsuarioDAO.save(intentoUsuario);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Error al crear la intento usuario", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try {
            intentoUsuarioDAO.deleteById(id);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }


    /**
     * Mappers
     */

    //DTO --> Entity
    public IntentoUsuarioEntity mapperIntentoUsuarioDTOEntity(IntentoUsuarioDTO intentoUsuarioDTO) throws ServiceException {

        IntentoUsuarioEntity intentoUsuarioEntity = new IntentoUsuarioEntity();
        UsuarioEntity usuarioEntity = usuarioService.findUsuarioEntityById(intentoUsuarioDTO.getUsuarioIdUsuario().getIdUsuario());
        PreguntaEntity preguntaEntity = preguntaService.findPreguntaEntityById(intentoUsuarioDTO.getPreguntaIdPregunta().getIdPregunta());
        RespuestaEntity respuestaEntity = respuestaService.findRespuestaEntityById(intentoUsuarioDTO.getRespuestaIdRespuesta().getIdRespuesta());
        intentoUsuarioEntity.setCorrecta(respuestaEntity.getCorrecta());//Toma el valor de la respuesta
        intentoUsuarioEntity.setRespuestaAbierta(intentoUsuarioDTO.getRespuesta_abierta());
        intentoUsuarioEntity.setFechaRespuesta(util.fechaActual());
        intentoUsuarioEntity.setUsuarioByUsuarioIdUsuario(usuarioEntity);
        intentoUsuarioEntity.setPreguntaByPreguntaIdPregunta(preguntaEntity);
        intentoUsuarioEntity.setRespuestaByRespuestaByIdRespuesta(respuestaEntity);
        return intentoUsuarioEntity;
    }

    public IntentoUsuarioDTO mapperIntentoUsuarioEntityDTO(IntentoUsuarioEntity intentoUsuarioEntity){
        return IntentoUsuarioDTO.builder()
                .estado(intentoUsuarioEntity.getCorrecta())
                .respuesta_abierta(intentoUsuarioEntity.getRespuestaAbierta())
                .fechaRespuesta(intentoUsuarioEntity.getFechaRespuesta())
                .usuarioIdUsuario(new UsuarioDTO(
                        intentoUsuarioEntity.getUsuarioByUsuarioIdUsuario().getNumeroDocumento(),
                        intentoUsuarioEntity.getUsuarioByUsuarioIdUsuario().getNombre(),
                        intentoUsuarioEntity.getUsuarioByUsuarioIdUsuario().getApellido(),
                        intentoUsuarioEntity.getUsuarioByUsuarioIdUsuario().getImagenPerfil())
                )
                .preguntaIdPregunta(new PreguntaDTO(
                        intentoUsuarioEntity.getPreguntaByPreguntaIdPregunta().getIdPregunta(),
                        intentoUsuarioEntity.getPreguntaByPreguntaIdPregunta().getTitulo()
                        )
                )
                .respuestaIdRespuesta(new RespuestaDTO(
                        intentoUsuarioEntity.getRespuestaByRespuestaByIdRespuesta().getRespuesta(),
                        intentoUsuarioEntity.getRespuestaByRespuestaByIdRespuesta().getCorrecta()

                ))
                .build();
    }
}
