package com.deme.biblioteca;
import com.deme.biblioteca.repository.BibliotecaRepository;
import com.deme.biblioteca.model.Libro;
import com.deme.biblioteca.service.LibroService;
import com.deme.biblioteca.service.LibroYaExisteException;

import java.time.Year;

public class App {
    public static void main(String[] args) {
        BibliotecaRepository repository = new BibliotecaRepository();
        LibroService service = new LibroService(repository);

        Libro libro1 = new Libro(
                "ABC123",
                "El niño y la bruja",
                "Luis Demetrio Tejeda Tlazalo",
                Year.of(2009),
                true);

        Libro libro2 = new Libro(
                "ABC123",
                "El niño y la bruja",
                "Luis Demetrio Tejeda Tlazalo",
                Year.of(2009),
                true);

        try {
            service.registrarLibro(libro1);
            System.out.println("Libro registrado com éxito.");
        }catch (LibroYaExisteException e) {
            System.out.println("Error: " +e.getMessage());
        }

        try {
            service.registrarLibro(libro2);
            System.out.println("Libro registrado con éxito");
        }catch (LibroYaExisteException e) {
            System.out.println("Error: "+ e.getMessage());
        }

    }
}
