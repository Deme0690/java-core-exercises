/*
   Se ocupa de la lógica de negocio.
   "¿Está permitido hacer esta operación?"
   Ejemplo: Quiero registrar un libro, pero no puedo registrar un ISBN que ya exista
 */
package com.deme.biblioteca.service;

import com.deme.biblioteca.model.Libro;
import com.deme.biblioteca.repository.BibliotecaRepository;
import java.util.Optional;

public class LibroService {
    private final BibliotecaRepository repository;

    public LibroService(BibliotecaRepository repository) {
        this.repository = repository;
    }

    public void registrarLibro(Libro libro) {
        String miISBN = libro.getIsbn();

        Optional<Libro> optLibro = repository.buscarPorISBN(miISBN);
        if (optLibro.isPresent()) {
            //El libro sí existe. No se puedo volver a registrar
            throw new LibroYaExisteException("Libro existente");
        }
        // El ISBN aún no existe, se puede registrar
        repository.agregarLibro(libro);
    }

    public void prestarLibro(String isbn) {
        //Buscamos la existencia del libro
        Optional<Libro> optLibro = repository.buscarPorISBN(isbn);

        if (optLibro.isEmpty()) {
            // El libro no se encuentra registrado
            throw new LibroNoExisteException("Libro no encontrado");
        }

        // El libro existe. Buscamos disponibilidad.
        Libro libro = optLibro.get();

        if (!libro.isDisponible()) {
            throw new LibroNoDisponibleException("Libro no disponible");
        }

        // Se puede prestar el libro
        libro.setDisponible(false);

    }
}
