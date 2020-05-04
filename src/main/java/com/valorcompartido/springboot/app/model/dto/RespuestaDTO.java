package com.valorcompartido.springboot.app.model.dto;


import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.entity.PreguntaEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="Respuesta DTO info", description = "Dto respuesta")
public class RespuestaDTO {

    @Schema
    private Integer idRespuesta;

    @Schema(example = "Colombia")
    private String respuesta;

    @Schema(example = "CORRECTA")
    private Estado estado;

    private PreguntaDTO preguntaIdPregunta;

    public RespuestaDTO(String respuesta, Estado correcta) {
        this.respuesta = respuesta;
        this.estado = correcta;
    }
}
