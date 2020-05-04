package com.valorcompartido.springboot.app.controller;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.PreguntaDTO;
import com.valorcompartido.springboot.app.model.entity.PreguntaEntity;
import com.valorcompartido.springboot.app.services.impl.IPreguntaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/pregunta")
public class PreguntaApiController {

    private final IPreguntaService service;


    public PreguntaApiController(IPreguntaService service) {
        this.service = service;
    }

    @GetMapping("/lista")
    public List<PreguntaDTO> listaSubCategoria() throws ServiceException {
        return service.listaPregunta();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PreguntaDTO findPreguntaById(@PathParam("id") Integer id) throws ServiceException {
        return service.findPreguntaById(id);
    }

    @GetMapping("/quiz/{id}")
    public List<PreguntaDTO> findByIdQuiz(@PathParam("id") Integer id) throws ServiceException {
        return service.finPreguntaByIdQuiz(id);
    }

    @GetMapping("titulo/{titulo}")
    public List<PreguntaDTO> findByTitulo(@PathParam("titulo") String titulo) throws ServiceException {
        return service.findByTitleLike(titulo);
    }

    @PostMapping(value = "/crear",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PreguntaDTO> create(@RequestBody PreguntaDTO preguntaDTO) throws ServiceException {
        PreguntaDTO pregunta = service.create(preguntaDTO);
        return new ResponseEntity<>(pregunta, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PreguntaEntity> update(@RequestBody PreguntaDTO preguntaDTO) throws ServiceException {
        PreguntaEntity pregunta = service.update(preguntaDTO);
        return new ResponseEntity<>(pregunta, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws ServiceException {
        service.delete(id);
    }

}
