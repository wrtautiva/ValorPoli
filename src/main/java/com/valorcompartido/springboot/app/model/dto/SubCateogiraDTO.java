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
@Schema(name = "Sub categoria Dto info", description = "Dto de sub categoria")
public class SubCateogiraDTO {

    @Schema
    private Integer idSubCategoria;
    @Schema(example = "Titulo sub categoria")
    private String titulo;
    @Schema(example = "2019-11-28")
    private String fechaCreacion;
    @Schema(example ="ACTIVO")
    private Estado estado;
    @Schema
    private CategoriaDTO categoriaIdCategoria;
}
