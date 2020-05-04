package com.valorcompartido.springboot.app.controller;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.UsuarioDTO;
import com.valorcompartido.springboot.app.model.entity.UsuarioEntity;
import com.valorcompartido.springboot.app.services.UsuarioServiceJP;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioApiController {

    private final UsuarioServiceJP service;

    public UsuarioApiController(UsuarioServiceJP service) {
        this.service = service;
    }

    @GetMapping("/lista")
    public List<UsuarioEntity> listaUsuario() throws ServiceException {
        return service.listaUsuario();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO findUserById(@PathParam("id") Integer id) throws ServiceException {
        return service.findusuarioById(id);
    }

    @GetMapping("documento/{documento}")
    public ResponseEntity<UsuarioDTO> findByDocument(@PathParam("documento") String documento) throws ServiceException {
        UsuarioDTO user = service.findByNumeroDocumento(documento);
        return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/crear",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioEntity> create(@RequestBody UsuarioDTO usuarioDTO) throws ServiceException {
        UsuarioEntity user = service.create(usuarioDTO);
        return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioEntity> update(@RequestBody UsuarioDTO usuarioDTO) throws ServiceException {
        UsuarioEntity user = service.update(usuarioDTO);
        return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws ServiceException {
        service.delete(id);
    }
}