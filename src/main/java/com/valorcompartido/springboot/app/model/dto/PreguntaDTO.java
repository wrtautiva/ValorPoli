package com.valorcompartido.springboot.app.model.dto;


import com.valorcompartido.springboot.app.model.emuns.TipoPregunta;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//Getter and setter
@NoArgsConstructor//Constructor vacio
@AllArgsConstructor//Constructor con todos los parametros
@Builder//Clase Inmutable
@Schema(name = "Pregunta DTO info",description =  "Dto Pregunta")
public class PreguntaDTO {

    @Schema
    private Integer idPregunta;

    @Schema
    private TipoPregunta tipoPregunta;

    @Schema(example = "¿Cuanto es dos más dos?")
    private String titulo;

    @Schema
    private QuizDTO QuizIdQuiz;

    public PreguntaDTO(int idPregunta,String titulo){
        this.idPregunta = idPregunta;
        this.titulo = titulo;
    }


}
