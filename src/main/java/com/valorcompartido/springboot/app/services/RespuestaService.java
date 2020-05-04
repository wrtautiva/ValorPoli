package com.valorcompartido.springboot.app.services;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.RespuestaDTO;
import com.valorcompartido.springboot.app.model.entity.PreguntaEntity;
import com.valorcompartido.springboot.app.model.entity.RespuestaEntity;

import java.util.List;

public interface RespuestaService {

    List<RespuestaDTO> listaRespuesta() throws ServiceException;

    RespuestaDTO findRespuestaById(Integer id) throws  ServiceException;

    RespuestaEntity findRespuestaEntityById(Integer id) throws ServiceException;

    RespuestaDTO create(RespuestaDTO respuestaDTO) throws ServiceException;

    RespuestaEntity update(RespuestaDTO respuestaDTO) throws ServiceException;

    void delete(Integer id) throws ServiceException;

    RespuestaEntity changeCorrect(RespuestaDTO respuestaDTO) throws ServiceException;

    List<RespuestaDTO> findByTitleLike(String titulo) throws ServiceException;

    List<RespuestaDTO> findRespuestaByPregunta(Integer id) throws ServiceException;
}
