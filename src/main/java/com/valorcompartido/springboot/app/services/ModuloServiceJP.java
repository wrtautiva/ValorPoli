package com.valorcompartido.springboot.app.services;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.entity.ModuloEntity;


public interface ModuloServiceJP {

    ModuloEntity findModuloEntityById(Integer id) throws ServiceException;

}
