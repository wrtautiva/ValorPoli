package com.valorcompartido.springboot.app.daos;

import com.valorcompartido.springboot.app.model.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDAO extends JpaRepository<QuizEntity,Integer> {
    //JPQL
    @Query("select q from QuizEntity q where q.idQuiz =:ID")
    QuizEntity findQuizEntityBy(@Param("ID") Integer id);

    @Query("select q from QuizEntity q where q.titulo LIKE CONCAT('%',:TITULO,'%')")
    List<QuizEntity> findQuizByTitulo(@Param("TITULO") String TITULO);

    @Query("select q from QuizEntity q where q.moduloIdModulo =:ID")
    List<QuizEntity> findQuizByIdModulo(@Param("ID") Integer id);

}
