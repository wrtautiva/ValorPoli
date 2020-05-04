package com.valorcompartido.springboot.app.daos;

import org.springframework.data.repository.CrudRepository;

import com.valorcompartido.springboot.app.model.Modulo;

public interface IModuloDao extends CrudRepository<Modulo, Long>{

}
