package com.deme.biblioteca.service;

public class LibroNoDisponibleException extends RuntimeException{
    public LibroNoDisponibleException(String message) {
        super(message); // Pasa el mensaje a la clase Exception de Java
    }
}
