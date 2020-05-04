package com.valorcompartido.springboot.app.controller;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.dto.IntentoUsuarioDTO;
import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.services.IntentoUsuarioService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/respuestaUsuario")
public class IntentoUsuarioApiController {
    private final IntentoUsuarioService service;

    public IntentoUsuarioApiController(IntentoUsuarioService service) {
        this.service = service;
    }

    @GetMapping("/lista")
    public List<IntentoUsuarioDTO> listaIntentoUsuario() throws ServiceException {
        return service.listaIntentoUsuario();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IntentoUsuarioDTO findIntengoUsuarioById(@PathParam("id") Integer id) throws ServiceException {
        return service.findIntentoUsuarioById(id);
    }

    @GetMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<IntentoUsuarioDTO> findIntengoUsuarioByIdUsuario(@PathParam("id") Integer id) throws ServiceException {
        return service.findIntentoUsuarioByIdUsuario(id);
    }

    @GetMapping("/pregunta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<IntentoUsuarioDTO> findIntentoUsuarioEntitiesByIdPregunta(@PathParam("id") Integer id) throws ServiceException {
        return service.findIntentoUsuarioEntitiesByIdPregunta(id);
    }

    @GetMapping("/respuesta/{estado}")
    @ResponseStatus(HttpStatus.OK)
    public List<IntentoUsuarioDTO> findIntentoUsuarioByCorrect(@PathParam("id") Estado estado) throws ServiceException {
        return service.findIntentoUsuarioByCorrect(estado);
    }

    @PostMapping(value = "/crear",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IntentoUsuarioDTO> create(@RequestBody IntentoUsuarioDTO intentoUsuarioDTO) throws ServiceException {
        IntentoUsuarioDTO intentousuario = service.create(intentoUsuarioDTO);
        return new ResponseEntity<>(intentousuario, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws ServiceException {
        service.delete(id);
    }
}
