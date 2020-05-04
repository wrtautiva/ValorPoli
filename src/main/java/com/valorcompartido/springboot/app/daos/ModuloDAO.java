package com.valorcompartido.springboot.app.daos;

import com.valorcompartido.springboot.app.model.entity.ModuloEntity;
import com.valorcompartido.springboot.app.model.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ModuloDAO extends JpaRepository<PreguntaEntity,Integer> {

    //JPQL
    @Query("select m from ModuloEntity m where m.idModulo =:ID")
    ModuloEntity findModuloEntityBy(@Param("ID") Integer id);

}
