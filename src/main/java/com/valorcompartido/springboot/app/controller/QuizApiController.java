package com.valorcompartido.springboot.app.controller;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.QuizDTO;
import com.valorcompartido.springboot.app.model.entity.QuizEntity;
import com.valorcompartido.springboot.app.services.QuizService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/quiz")
public class QuizApiController {

    private final QuizService service;

    public QuizApiController(QuizService service) {
        this.service = service;
    }

    @GetMapping("/lista")
    public List<QuizDTO> listaQuiz() throws ServiceException {
        return service.listarQuiz();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuizDTO findQuizById(@PathParam("id") Integer id) throws ServiceException {
        return service.findQuizById(id);
    }

    @GetMapping("/modulo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<QuizDTO> findQuizByIdModulo(@PathParam("id") Integer id) throws ServiceException {
        return service.findQuizByIdModulo(id);
    }

    @GetMapping("titulo/{titulo}")
    public List<QuizDTO> findByTitulo(@PathParam("titulo") String titulo) throws ServiceException {
        return service.findQuizByTitulo(titulo);
    }

    @PostMapping(value = "/crear",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuizDTO> create(@RequestBody QuizDTO quizDTO) throws ServiceException {
        QuizDTO quiz = service.create(quizDTO);
        return new ResponseEntity<>(quiz, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuizEntity> update(@RequestBody QuizDTO quizDTO) throws ServiceException {
        QuizEntity quiz = service.update(quizDTO);
        return new ResponseEntity<>(quiz, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws ServiceException {
        service.delete(id);
    }
}