package com.valorcompartido.springboot.app.daos;

import org.springframework.data.repository.CrudRepository;

import com.valorcompartido.springboot.app.model.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
//dao
}
