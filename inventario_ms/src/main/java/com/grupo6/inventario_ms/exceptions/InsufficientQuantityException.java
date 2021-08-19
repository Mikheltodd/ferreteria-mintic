package com.grupo6.inventario_ms.exceptions;

public class InsufficientQuantityException extends RuntimeException {

    public InsufficientQuantityException(String message) {
        super(message);
    }
}