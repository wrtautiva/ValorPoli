package com.valorcompartido.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valorcompartido.springboot.app.model.Usuario;
import com.valorcompartido.springboot.app.services.UsuarioService;

@Controller
public class UserController {
// controller
	@Autowired
	private UsuarioService usaservi;
	
	@RequestMapping("/")
	public String index(Model model ) {
		model.addAttribute("list",usaservi.getAll());
		
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave (@PathVariable("id") Long id, Model model) {
		if (id !=null &&  id!=0)  { 
		model.addAttribute("usuario", usaservi.get(id));
		}else {
			model.addAttribute("usuario", new Usuario());
		}
	return "save";
	}
	
	
	@PostMapping("/save")
	public String save(Usuario usuario,Model model ) {
		usaservi.save(usuario);
		return "redirect:/";
				
	}
	
	@GetMapping ("/delete/{id}")
	public String delete (@PathVariable Long id, Model model) {
		 usaservi.delete(id);
		
		return "redirect:/";
	}
}
