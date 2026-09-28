package com.deme.biblioteca.service;

public class LibroNoExisteException extends RuntimeException {
    public LibroNoExisteException(String message) {
        super(message);
    }
}