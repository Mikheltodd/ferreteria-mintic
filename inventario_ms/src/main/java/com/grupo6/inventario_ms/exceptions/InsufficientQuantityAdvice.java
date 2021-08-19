package com.grupo6.inventario_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@ResponseBody
public class InsufficientQuantityAdvice {
    @ResponseBody
    @ExceptionHandler(InsufficientQuantityException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String InsufficientBalanceAdvice(InsufficientQuantityException ex){
        return ex.getMessage();
    }
}