package com.godeltech.app.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Dmitry Chueshov 04.02.2021 15:33
 * @project application
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
    
    public ResourceNotFoundException(String message){
        super(message);
    }
}
