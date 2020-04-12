package com.valorcompartido.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
