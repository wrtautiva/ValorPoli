package com.valorcompartido.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valorcompartido.springboot.app.model.Usuario;
import com.valorcompartido.springboot.app.services.UsuarioService;

@RestController
@RequestMapping(value="/api/v1/")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usaservi;
	
	@GetMapping(value = "/all")
	public List<Usuario> getAll(){	
		return usaservi.getAll();
	}
	
	
	@PostMapping(value = "save")
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
	   Usuario obj=	usaservi.save(usuario);
	   return new ResponseEntity<Usuario>(obj,HttpStatus.OK);
					
	}
	
	
	@GetMapping(value = "/find/{id}")
	public Usuario find (@PathVariable Long id) {
		Usuario usuario =usaservi.get(id);
		return usuario;
	}
	

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable Long id){
		Usuario usuario  = usaservi.get(id);
		if(usuario  != null) {
		usaservi.delete(id);
		}else {
			return new  ResponseEntity<Usuario>(usuario , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new  ResponseEntity<Usuario>(usuario , HttpStatus.OK);
	}
	
	
}
