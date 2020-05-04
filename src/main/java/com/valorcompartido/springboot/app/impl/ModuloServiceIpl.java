package com.valorcompartido.springboot.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.valorcompartido.springboot.app.communds.GenericServiceImpl;
import com.valorcompartido.springboot.app.daos.IModuloDao;
import com.valorcompartido.springboot.app.model.Modulo;
import com.valorcompartido.springboot.app.services.ModuloService;

public class ModuloServiceIpl extends GenericServiceImpl<Modulo, Long> implements ModuloService {

	
	@Autowired
	private IModuloDao modulodao;
	
	@Override
	public CrudRepository<Modulo, Long> getDao() {

		return modulodao;
	}

}
