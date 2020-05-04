package com.valorcompartido.springboot.app.core.exceptions.persistence;


import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.core.exceptions.enums.LogRefServices;

public class DataNotFoundPersistenceException extends ServiceException {


    public DataNotFoundPersistenceException(LogRefServices logRefServices, String message) {
        super(logRefServices, message);
    }

    public DataNotFoundPersistenceException(LogRefServices logRefServices, String message, Throwable cause) {
        super(logRefServices, message, cause);
    }
}
