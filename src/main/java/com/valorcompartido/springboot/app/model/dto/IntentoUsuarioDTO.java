package com.valorcompartido.springboot.app.model.dto;


import com.valorcompartido.springboot.app.model.emuns.Estado;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Intento usuario DTO info", description = "Dto intento usuario")
public class IntentoUsuarioDTO {

    @Schema(example = "1")
    private Integer idIntento_usuario;

    @Schema(example = "CORRECTA")
    private Estado estado;

    @Schema(example = "Campo para el texto que él usuario ingresa para las preguntas abiertas")
    private String respuesta_abierta;

    @Schema(example = "2020-05-02- 07:57:16")
    private String fechaRespuesta;

    @Schema
    private UsuarioDTO usuarioIdUsuario;

    @Schema
    private PreguntaDTO preguntaIdPregunta;

    @Schema
    private RespuestaDTO respuestaIdRespuesta;

}
