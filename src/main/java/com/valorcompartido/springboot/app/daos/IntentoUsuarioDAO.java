package com.valorcompartido.springboot.app.daos;

import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.entity.IntentoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntentoUsuarioDAO extends JpaRepository<IntentoUsuarioEntity,Integer> {

    //Por ID de id
    @Query("SELECT i FROM IntentoUsuarioEntity i WHERE i.idIntentoUsuario =:ID")
    IntentoUsuarioEntity findIntentoUsuarioEntitiesById(@Param("ID") Integer id);

    //Por ID de usuario
    @Query("SELECT i FROM IntentoUsuarioEntity i WHERE i.usuarioIdUsuario =:ID")
    List<IntentoUsuarioEntity> findIntentoUsuarioEntitiesByIdUsuario(@Param("ID") Integer id);

    //Por ID de pregunta
    @Query("SELECT i FROM IntentoUsuarioEntity i WHERE i.preguntaIdPregunta =:ID")
    List<IntentoUsuarioEntity> findIntentoUsuarioEntitiesByIdPregunta(@Param("ID") Integer id);

    //Por respuesta correcta
    @Query("SELECT i FROM IntentoUsuarioEntity i WHERE i.correcta =:CORRECTA")
    List<IntentoUsuarioEntity> findIntentoUsuarioByCorrect(@Param("CORRECTA") Estado correcta);

    @Query("SELECT i FROM IntentoUsuarioEntity i INNER JOIN i.usuarioByUsuarioIdUsuario u WHERE u.numeroDocumento =:DOCUMENTO")
    List<IntentoUsuarioEntity> findResultadoUsuario(@Param("DOCUMENTO") String documentoUsuario);

}
