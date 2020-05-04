package com.valorcompartido.springboot.app.model.emuns;

import lombok.Getter;

public enum Estado {
    ACTIVO(1),
    DESACTIVADO(2),
    CORRECTA(3),
    INCORRECTA(4);

    @Getter
    Integer id;

    Estado(int id) {
    }
}
