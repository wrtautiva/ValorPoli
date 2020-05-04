package com.valorcompartido.springboot.app.core.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Util {

    public String fechaActual() {
        Date actual = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fecha = format.format(actual);
        return fecha;
    }
}
