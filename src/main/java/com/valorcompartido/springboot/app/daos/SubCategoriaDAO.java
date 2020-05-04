package com.valorcompartido.springboot.app.daos;
;
import com.valorcompartido.springboot.app.model.entity.SubCategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoriaDAO extends JpaRepository<SubCategoriaEntity,Integer> {

    //JPQL
    @Query("SELECT s FROM SubCategoriaEntity s WHERE s.idSubCategoria=:ID")
    SubCategoriaEntity findSubCategoriaEntityBy(@Param("ID") Integer id);

    @Query("SELECT s FROM SubCategoriaEntity s WHERE s.titulo LIKE CONCAT('%',:TITULO,'%')")
    List<SubCategoriaEntity> findByTitleLike(@Param("TITULO") String titulo);
}
