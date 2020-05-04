package com.valorcompartido.springboot.app.model.dto;

import com.valorcompartido.springboot.app.model.emuns.Estado;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//Getter and setter
@NoArgsConstructor//Constructor vacio
@AllArgsConstructor//Constructor con todos los parametros
@Builder//Clase Inmutable
@Schema(name = "Categoria DTO info", description = "Dto categoria")
public class CategoriaDTO {

    @Schema(example = "1")
    private Integer idCategoria;

    @Schema(example = "Titulo categoria")
    private String titulo;

    @Schema(example = "2019-11-28")
    private String fechaCreacion;

    @Schema(example = "ACTIVO")
    private Estado estado;


    public CategoriaDTO(int idCategoria, String titulo, String fechaCreacion) {
        this.idCategoria = idCategoria;
        this.titulo = titulo;
        this.fechaCreacion=fechaCreacion;
    }
}
