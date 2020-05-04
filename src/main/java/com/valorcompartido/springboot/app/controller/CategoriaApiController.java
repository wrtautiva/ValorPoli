package com.valorcompartido.springboot.app.controller;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.CategoriaDTO;
import com.valorcompartido.springboot.app.model.entity.CategoriaEntity;
import com.valorcompartido.springboot.app.services.CategoriaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/categoria")
public class CategoriaApiController {

    private final CategoriaService service;

    public CategoriaApiController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/lista")
    public List<CategoriaEntity> listCategoria() throws ServiceException {
        return service.listaCategoria();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaDTO findCategoriaById(@PathParam("id") Integer id) throws ServiceException {
        return service.findCategoriaById(id);
    }

    @GetMapping("titulo/{titulo}")
    public List<CategoriaDTO> findByTitleLike(@PathParam("titulo") String titulo) throws ServiceException {
        //CategoriaDTO categoria = service.findByTitleLike(titulo);
        return service.findByTitleLike(titulo);
        //return new ResponseEntity<>(categoria, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/crear",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaEntity> create(@RequestBody CategoriaDTO categoriaDTO) throws ServiceException {
        CategoriaEntity categoria = service.create(categoriaDTO);
        return new ResponseEntity<>(categoria, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaEntity> update(@RequestBody CategoriaDTO categoriaDTO) throws ServiceException {
        CategoriaEntity categoria = service.update(categoriaDTO);
        return new ResponseEntity<>(categoria, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws ServiceException {
        service.delete(id);
    }
}