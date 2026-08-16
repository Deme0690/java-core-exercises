package com.deme.biblioteca.repository;

import com.deme.biblioteca.model.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BibliotecaRepository {

    private final List<Libro> libros = new ArrayList<>();
    private Stream<Libro> librosStream =
            libros.stream();


    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Optional<Libro> buscarPorISBN(String isbn) {
        /*
            Optional con Libro     → encontrado
            Optional.empty()       → no encontrado
         */

        //Operando sobre el stream
        return librosStream
                .filter(libro-> libro.getIsbn().equals(isbn))
                .findFirst();
    }

    public List<Libro> obtenerTodos() {
        return  List.copyOf(libros);
    }

}
