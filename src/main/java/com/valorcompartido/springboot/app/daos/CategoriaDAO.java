package com.valorcompartido.springboot.app.daos;

import com.valorcompartido.springboot.app.model.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaDAO extends JpaRepository<CategoriaEntity,Integer> {

    //JPQL
    @Query("SELECT c FROM CategoriaEntity c WHERE c.idCategoria=:ID")
    CategoriaEntity findCategoriaEntityBy(@Param("ID") Integer id);

    @Query("SELECT c FROM CategoriaEntity c WHERE c.titulo LIKE CONCAT('%',:TITULO,'%')")
    List<CategoriaEntity> findByTitleLike(@Param("TITULO") String title);

}
