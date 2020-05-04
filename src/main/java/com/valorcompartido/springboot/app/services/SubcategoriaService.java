package com.valorcompartido.springboot.app.services;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto. SubCateogiraDTO;
import com.valorcompartido.springboot.app.model.entity.SubCategoriaEntity;

import java.util.List;

public interface SubcategoriaService {

    List<SubCateogiraDTO> listaSubCategoria() throws ServiceException;

    SubCateogiraDTO findSubCategoriaById(Integer id) throws ServiceException;

    SubCateogiraDTO create(SubCateogiraDTO categoriaDTO) throws ServiceException;

    SubCategoriaEntity update(SubCateogiraDTO categoriaDTO) throws ServiceException;

    void delete(Integer id) throws ServiceException ;

    SubCategoriaEntity disable(SubCateogiraDTO categoriaDTO) throws ServiceException;

    List<SubCateogiraDTO> findByTitleLike(String titulo) throws ServiceException;
}
