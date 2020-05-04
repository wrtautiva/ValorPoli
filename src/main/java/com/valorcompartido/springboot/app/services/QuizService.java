package com.valorcompartido.springboot.app.services;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.entity.QuizEntity;
import com.valorcompartido.springboot.app.model.dto.QuizDTO;

import java.util.List;

public interface QuizService {


    List<QuizDTO> listarQuiz() throws ServiceException;

    QuizDTO findQuizById(Integer Id) throws ServiceException;

    QuizEntity findQuizEntityById(Integer id) throws ServiceException;

    List<QuizDTO> findQuizByIdModulo(Integer id) throws ServiceException;

    QuizDTO create(QuizDTO quizDTO) throws  ServiceException;

    QuizEntity update(QuizDTO quizDTO) throws  ServiceException;

    void delete (Integer id) throws ServiceException;

    QuizEntity disable(QuizDTO quizDTO) throws ServiceException;

    List<QuizDTO> findQuizByTitulo(String titulo) throws ServiceException;

}
