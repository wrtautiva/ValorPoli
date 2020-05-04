package com.valorcompartido.springboot.app.services.impl;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.core.exceptions.enums.LogRefServices;
import com.valorcompartido.springboot.app.core.exceptions.persistence.DataNotFoundPersistenceException;
import com.valorcompartido.springboot.app.daos.UsuarioDAO;
import com.valorcompartido.springboot.app.model.dto.TipoDocumentoDTO;
import com.valorcompartido.springboot.app.model.dto.UsuarioDTO;
import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.emuns.TipoDocumento;
import com.valorcompartido.springboot.app.model.entity.UsuarioEntity;
import com.valorcompartido.springboot.app.services.UsuarioService;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

@Service
public class IUsuarioService implements UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public IUsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public List<UsuarioEntity> listaUsuario() throws ServiceException {
        try {
            return Optional.of(usuarioDAO.findAll())
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public UsuarioDTO findusuarioById(Integer id) throws ServiceException {
        try {
            return Optional.of(usuarioDAO.finUsuarioEntityById(id)).map(this::mapperUsuarioEntityDTO)
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public UsuarioEntity findUsuarioEntityById(Integer id) throws ServiceException {
        try {
            return Optional.ofNullable(usuarioDAO.finUsuarioEntityById(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    public UsuarioDTO mapperUsuarioEntityDTO(UsuarioEntity entity) {
        return UsuarioDTO.builder()
                .apellido(entity.getApellido())
                .nombre(entity.getNombre())
                .email(entity.getEmail())
                .descripcion(entity.getDescripcion())
                .build();
    }

    @Override
    public UsuarioEntity create(UsuarioDTO userDto) throws ServiceException {
        try {
            return usuarioDAO.save(mapperUsuarioDTOEntity(userDto));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "eror al crear el usuario" + userDto , pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    public UsuarioEntity mapperUsuarioDTOEntity(UsuarioDTO usuarioDTO) {
        UsuarioEntity user = new UsuarioEntity();
        user.setNombre(usuarioDTO.getNombre());
        user.setTipoDocumento(usuarioDTO.getTipoDocumento());
        user.setEstado(usuarioDTO.getEstado());
        user.setEmail(usuarioDTO.getEmail());
        user.setNumeroDocumento(usuarioDTO.getNumeroDocumento());
        user.setApellido(usuarioDTO.getApellido());
        user.setDescripcion(usuarioDTO.getDescripcion());
        user.setImagenPerfil(usuarioDTO.getImagenPerfil());
        user.setOcupacion(usuarioDTO.getOcupacion());
        user.setPassword(usuarioDTO.getPassword());

        return user;

    }

    @Override
    public UsuarioEntity update (UsuarioDTO usuarioDTO) throws ServiceException {
       try {
           UsuarioEntity userActual= usuarioDAO.findByNumeroDocumento(usuarioDTO.getNumeroDocumento());
           userActual.setNombre(usuarioDTO.getNombre());
           return usuarioDAO.save(userActual);
       }catch (IllegalArgumentException | PersistenceException pe) {
           throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "eror al crear el usuario" , pe);
       } catch (Exception e) {
           throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
       }

    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try {
            usuarioDAO.deleteById(id);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public UsuarioEntity disable(Estado estado, Integer id) throws ServiceException {
        return null;
    }

    @Override
    public UsuarioDTO findByNumeroDocumento(String documento) throws ServiceException {
        try {
            return Optional.of(usuarioDAO.findByNumeroDocumento(documento)).map(this::mapperUsuarioEntityDTO)
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el documento", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }
}
