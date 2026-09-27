package com.deme.biblioteca.service;

public class LibroYaExisteException extends RuntimeException{
    public LibroYaExisteException(String message) {
        super(message); // Pasa el mensaje a la clase Exception de Java
    }
}
