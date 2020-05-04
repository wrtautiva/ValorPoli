package com.valorcompartido.springboot.app.model.emuns;

import lombok.Getter;

public enum TipoPregunta {

    CERRADA(1,"Cerrada"),
    ABIERTA(2,"Abierta");

    @Getter
    public Integer id;
    @Getter
    public String descripcion;

    TipoPregunta(int id, String descripcion) {
    }
}
