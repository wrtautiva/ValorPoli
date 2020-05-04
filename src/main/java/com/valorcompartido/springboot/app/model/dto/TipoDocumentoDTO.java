package com.valorcompartido.springboot.app.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "TipoDocumentoDTO Dto info", description = "Dto de TipoDocumentoDTO")
public class TipoDocumentoDTO {
    @Schema
    private Integer id;
}
