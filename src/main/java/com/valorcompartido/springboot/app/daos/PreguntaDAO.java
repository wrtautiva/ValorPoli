package com.valorcompartido.springboot.app.daos;

import com.valorcompartido.springboot.app.model.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaDAO extends JpaRepository<PreguntaEntity,Integer> {


    @Query("select p from PreguntaEntity p where p.idPregunta=:ID")
    PreguntaEntity finPreguntaEntityById(@Param("ID") Integer id);

    @Query("SELECT p FROM PreguntaEntity p WHERE p.titulo LIKE CONCAT('%',:TITULO,'%')")
    List<PreguntaEntity> findByTitleLike(@Param("TITULO") String title);

    @Query("select p from PreguntaEntity p where p.quizIdQuiz=:ID")
    List<PreguntaEntity> finPreguntaByIdQuiz(@Param("ID") Integer id);

}
