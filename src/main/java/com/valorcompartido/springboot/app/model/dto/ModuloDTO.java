package com.valorcompartido.springboot.app.model.dto;

import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.entity.UsuarioEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//Getter and setter
@NoArgsConstructor//Constructor vacio
@AllArgsConstructor//Constructor con todos los parametros
@Builder//Clase Inmutable
@Schema(name = "Modulo DTO info", description = "Dto Modulo")
public class ModuloDTO {

    @Schema(example = "1")
    private Integer idModulo;
    @Schema(example = "Mi primer modulo")
    private String titulo;
    @Schema(example = "2020-11-28 08:30:25")
    private String fechaCreacion;
    @Schema(example = "ACTIVO")
    private Estado estado;
    @Schema(example = "No se para que este campo")
    private String tipoContenido;
    /*@Schema(example = "1")
    private SubCateogiraDTO subCategoriaIdSubCategoria;*/

    public ModuloDTO(int idModulo, String titulo, String fechaCreacion, Estado estado) {
        this.idModulo = idModulo;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }
}
