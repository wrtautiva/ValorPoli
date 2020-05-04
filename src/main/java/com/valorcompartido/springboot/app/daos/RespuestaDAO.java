package com.valorcompartido.springboot.app.daos;


import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.entity.RespuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaDAO extends JpaRepository<RespuestaEntity,Integer> {

    @Query("SELECT r FROM RespuestaEntity r WHERE r.idRespuesta =:ID")
    RespuestaEntity findRespuestaEntityById(@Param("ID") Integer id);

    @Query("SELECT r FROM RespuestaEntity r WHERE r.correcta =:CORRECTA")
    RespuestaEntity findRespuestaEntyEntityByCorrect(@Param("CORRECTA") Estado correcta);

    @Query("SELECT r FROM RespuestaEntity r WHERE r.preguntaIdPregunta =:ID")
    List<RespuestaEntity> findRespuestaEntityByPregunta(@Param("ID") Integer id);

    @Query("SELECT r FROM RespuestaEntity r WHERE r.respuesta LIKE CONCAT('%',:TITULO,'%')")
    List<RespuestaEntity> findByRespuestaLike(@Param("TITULO") String titulo);
}

