package com.valorcompartido.springboot.app.services;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.UsuarioDTO;
import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.entity.UsuarioEntity;

import java.util.List;


public interface UsuarioServiceJP {

    List<UsuarioEntity> listaUsuario() throws ServiceException;

    UsuarioDTO findusuarioById(Integer id) throws ServiceException;

    UsuarioEntity findUsuarioEntityById(Integer id) throws ServiceException;

    UsuarioEntity create(UsuarioDTO userDto) throws ServiceException;

    UsuarioEntity update(UsuarioDTO usuarioDTO) throws ServiceException;

    void delete(Integer id) throws ServiceException;

    UsuarioEntity disable(Estado estado, Integer id) throws ServiceException;

    UsuarioDTO findByNumeroDocumento(String documento) throws ServiceException;

}
