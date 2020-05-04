package com.valorcompartido.springboot.app.model.dto;


import com.valorcompartido.springboot.app.model.emuns.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data//Getter and setter
@NoArgsConstructor//Constructor vacio
@AllArgsConstructor//Constructor con todos los parametros
@Builder//Clase Inmutable
@Schema(name = "Quiz DTO info",description =  "Dto Quiz")
public class QuizDTO {

    @Schema
    private Integer idQuiz;
    @Schema(example = "Quiz reposteria")
    private String titulo;
    @Schema(example = "Este es un quiz de prueba")
    private String descripcion;
    @Schema(example ="ACTIVO")
    private Estado estado;
    @Schema
    private ModuloDTO moduloIdModulo;

    public QuizDTO(int idQuiz, String titulo, String descripcion) {
        this.idQuiz = idQuiz;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
}
