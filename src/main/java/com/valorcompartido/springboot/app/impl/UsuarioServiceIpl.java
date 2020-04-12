package com.valorcompartido.springboot.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.valorcompartido.springboot.app.communds.GenericServiceImpl;
import com.valorcompartido.springboot.app.daos.IUsuarioDao;
import com.valorcompartido.springboot.app.model.Usuario;
import com.valorcompartido.springboot.app.services.UsuarioService;

@Service
public class UsuarioServiceIpl extends GenericServiceImpl<Usuario, Long >  implements UsuarioService{
	
	@Autowired
	private IUsuarioDao usuariodao;
	@Override
	public CrudRepository<Usuario, Long> getDao() {
		
		return usuariodao;
	}
	
	 

}
