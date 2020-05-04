package com.valorcompartido.springboot.app.services;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.IntentoUsuarioDTO;
import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.entity.IntentoUsuarioEntity;

import java.util.List;

public interface IntentoUsuarioService {

    List<IntentoUsuarioDTO> listaIntentoUsuario() throws ServiceException;

    IntentoUsuarioDTO findIntentoUsuarioById(Integer id) throws ServiceException;

    List<IntentoUsuarioDTO> findIntentoUsuarioByIdUsuario(Integer id) throws ServiceException;

    List<IntentoUsuarioDTO> findIntentoUsuarioEntitiesByIdPregunta(Integer id) throws ServiceException;

    List<IntentoUsuarioDTO> findIntentoUsuarioByCorrect(Estado correcta) throws ServiceException;

    IntentoUsuarioDTO create(IntentoUsuarioDTO intentoUsuarioDTO) throws ServiceException;

    IntentoUsuarioEntity update(IntentoUsuarioDTO intentoUsuarioDTO) throws ServiceException;

    void delete(Integer id) throws ServiceException ;

}
