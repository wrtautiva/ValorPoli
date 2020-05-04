package com.valorcompartido.springboot.app.services;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.PreguntaDTO;
import com.valorcompartido.springboot.app.model.entity.PreguntaEntity;

import java.util.List;

public interface PreguntaService {

    List<PreguntaDTO> listaPregunta() throws ServiceException;

    PreguntaDTO findPreguntaById(Integer id) throws ServiceException;

    PreguntaEntity findPreguntaEntityById(Integer id) throws ServiceException;

    List<PreguntaDTO> finPreguntaByIdQuiz(Integer id) throws ServiceException;

    PreguntaDTO create(PreguntaDTO preguntaDTO) throws ServiceException;

    PreguntaEntity update(PreguntaDTO preguntaDTO) throws ServiceException;

    void delete(Integer id) throws ServiceException;

    PreguntaEntity disable(PreguntaDTO preguntaDTO) throws ServiceException;

    List<PreguntaDTO> findByTitleLike(String titulo) throws ServiceException;
}
