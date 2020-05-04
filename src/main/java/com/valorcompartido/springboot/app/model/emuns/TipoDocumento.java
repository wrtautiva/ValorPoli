package com.valorcompartido.springboot.app.model.emuns;

import lombok.Getter;


public enum TipoDocumento {
    CC(1,"Cedula"),
    NIT(2,"Numero de identificacion tributaria");

    @Getter
    public Integer id;
    @Getter
    public String descripcion;

    TipoDocumento(int id, String descripcion) {
    }
}
