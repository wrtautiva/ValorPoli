package com.valorcompartido.springboot.app.daos;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.model.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<UsuarioEntity,Integer> {

    @Query("select u from UsuarioEntity u where u.idUsuario=:ID")
    UsuarioEntity finUsuarioEntityById(@Param("ID") Integer id);

    UsuarioEntity findByNumeroDocumento(String documento);
}
