package com.valorcompartido.springboot.app.controller;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.SubCateogiraDTO;
import com.valorcompartido.springboot.app.model.entity.SubCategoriaEntity;
import com.valorcompartido.springboot.app.services.SubcategoriaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/subcategoria")
public class SubCategoriaApiController {

    private final SubcategoriaService service;

    public SubCategoriaApiController(SubcategoriaService service) {
        this.service = service;
    }

    @GetMapping("/lista")
    public List<SubCateogiraDTO> listaSubCategoria() throws ServiceException {
        return service.listaSubCategoria();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SubCateogiraDTO findSubCategoriaById(@PathParam("id") Integer id) throws ServiceException {
        return service.findSubCategoriaById(id);
    }

    @GetMapping("titulo/{titulo}")
    public List<SubCateogiraDTO> findByTitulo(@PathParam("titulo") String titulo) throws ServiceException {
        return service.findByTitleLike(titulo);
    }

    @PostMapping(value = "/crear",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubCateogiraDTO> create(@RequestBody SubCateogiraDTO subCateogiraDTO) throws ServiceException {
        SubCateogiraDTO subCategoria = service.create(subCateogiraDTO);
        return new ResponseEntity<>(subCategoria, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubCategoriaEntity> update(@RequestBody SubCateogiraDTO subCateogiraDTO) throws ServiceException {
        SubCategoriaEntity subCategoria = service.update(subCateogiraDTO);
        return new ResponseEntity<>(subCategoria, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws ServiceException {
        service.delete(id);
    }
}
