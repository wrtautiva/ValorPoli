package com.valorcompartido.springboot.app.services;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.CategoriaDTO;
import com.valorcompartido.springboot.app.model.entity.CategoriaEntity;


import java.util.List;

public interface CategoriaService {


    List<CategoriaEntity> listaCategoria() throws ServiceException;

    CategoriaDTO findCategoriaById(Integer id) throws ServiceException;

    CategoriaEntity findCategoriaEntityById(Integer id) throws ServiceException;

    CategoriaEntity create(CategoriaDTO categoriaDTO) throws ServiceException;

    CategoriaEntity update(CategoriaDTO categoriaDTO) throws ServiceException;

    void delete(Integer id) throws ServiceException ;

    CategoriaEntity disable(CategoriaDTO categoriaDTO) throws ServiceException;

    List<CategoriaDTO> findByTitleLike(String titulo) throws ServiceException;

}
