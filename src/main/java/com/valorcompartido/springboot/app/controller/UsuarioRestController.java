package com.valorcompartido.springboot.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.valorcompartido.springboot.app.model.Usuario;
import com.valorcompartido.springboot.app.services.UsuarioService;

@RestController
public class UsuarioRestController {

	private UsuarioService usaservi;
	
	public List<Usuario> getAll(){
		
		
		return usaservi.getAll();
		
	}
}
