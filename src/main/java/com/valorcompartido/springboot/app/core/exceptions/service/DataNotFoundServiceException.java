package com.valorcompartido.springboot.app.core.exceptions.service;


import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.core.exceptions.enums.LogRefServices;

public class DataNotFoundServiceException extends ServiceException {

    public DataNotFoundServiceException(LogRefServices logRefServices, String message) {
        super(logRefServices, message);
    }

    public DataNotFoundServiceException(LogRefServices logRefServices, String message, Throwable cause) {
        super(logRefServices, message, cause);
    }
}
