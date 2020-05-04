package com.valorcompartido.springboot.app.model.dto;


import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.emuns.TipoDocumento;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Usuario Dto info", description = "Dto de usuario")
public class UsuarioDTO {

    @Schema
    private Integer idUsuario;
    @Schema
    private TipoDocumento tipoDocumento;
    @Schema(example = "123456789")
    private String numeroDocumento;
    @Schema(example = "Pepito")
    private String nombre;
    @Schema(example = "Juarez")
    private String apellido;
    @Schema(example = "pepiJuate@gmail.com")
    private String email;
    @Schema(example = "123")
    private String password;
    @Schema(example = "Dormir")
    private String ocupacion;
    @Schema(example = "Soy el mejor en todo lo que hago")
    private String descripcion;
    @Schema(example = "yo.jpg")
    private String imagenPerfil;
    @Schema
    private Estado estado;

    public UsuarioDTO(String numeroDocumento, String nombre, String apellido, String imagenPerfil) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.imagenPerfil = imagenPerfil;
    }
}
