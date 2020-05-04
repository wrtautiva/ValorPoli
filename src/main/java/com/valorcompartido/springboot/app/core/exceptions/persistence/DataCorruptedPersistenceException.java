package com.valorcompartido.springboot.app.core.exceptions.persistence;


import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.core.exceptions.enums.LogRefServices;

public class DataCorruptedPersistenceException extends ServiceException {

    public DataCorruptedPersistenceException(LogRefServices logRefServices, String message) {
        super(logRefServices, message);
    }

    public DataCorruptedPersistenceException(LogRefServices logRefServices, String message, Throwable cause) {
        super(logRefServices, message, cause);
    }
}
