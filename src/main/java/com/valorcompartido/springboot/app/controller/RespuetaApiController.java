package com.valorcompartido.springboot.app.controller;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.RespuestaDTO;
import com.valorcompartido.springboot.app.model.entity.RespuestaEntity;
import com.valorcompartido.springboot.app.services.RespuestaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/respuesta")
public class RespuetaApiController {

    private final RespuestaService service;

    public RespuetaApiController(RespuestaService service) {
        this.service = service;
    }

    @GetMapping("/lista")
    public List<RespuestaDTO> listaRespuesta() throws ServiceException {
        return service.listaRespuesta();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RespuestaDTO findRespuestaById(@PathParam("id") Integer id) throws ServiceException {
        return service.findRespuestaById(id);
    }

    @GetMapping("/pregunta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<RespuestaDTO> findRespuestaByIdPregunta(@PathParam("id") Integer id) throws ServiceException {
        return service.findRespuestaByPregunta(id);
    }

    @GetMapping("titulo/{titulo}")
    public List<RespuestaDTO> findByTitulo(@PathParam("titulo") String titulo) throws ServiceException {
        return service.findByTitleLike(titulo);
    }

    @PostMapping(value = "/crear",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaDTO> create(@RequestBody RespuestaDTO respuestaDTO) throws ServiceException {
        RespuestaDTO respuesta = service.create(respuestaDTO);
        return new ResponseEntity<>(respuesta, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaEntity> update(@RequestBody RespuestaDTO respuestaDTO) throws ServiceException {
        RespuestaEntity respuesta = service.update(respuestaDTO);
        return new ResponseEntity<>(respuesta, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/correcta",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaEntity> updateCorrect(@RequestBody RespuestaDTO respuestaDTO) throws ServiceException {
        RespuestaEntity respuesta = service.changeCorrect(respuestaDTO);
        return new ResponseEntity<>(respuesta, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws ServiceException {
        service.delete(id);
    }
}
