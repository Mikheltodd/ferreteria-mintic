package com.grupo6.inventario_ms.exceptions;


public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}