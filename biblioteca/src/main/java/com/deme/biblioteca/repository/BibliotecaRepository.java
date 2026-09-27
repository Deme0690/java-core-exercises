/*
    Esta clase solamente sabe: guardar, buscar y obtener
    Esto se ocupa de: Dame el libro cuyo ISBN sea X
 */

package com.deme.biblioteca.repository;

import com.deme.biblioteca.model.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BibliotecaRepository {

    private final List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Optional<Libro> buscarPorISBN(String isbn) {
        /*
            Optional con Libro     → encontrado
            Optional.empty()       → no encontrado
         */

        //Crear stream de libros y operar.
        return libros.stream()
                .filter(libro-> libro.getIsbn().equals(isbn))
                .findFirst();

        /*
        Similar a:
        private Stream<Libro> librosStream = libros.stream();
        librosStream
            .filter(...)
            .findFirst(...);
        */
    }

    public List<Libro> obtenerTodos() {
        return  List.copyOf(libros);
    }

}
