package com.deme.biblioteca.model;

import java.time.Year;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private Year anio;
    private boolean disponible;

    public Libro(String isbn, String titulo, String autor, Year anio, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponible = disponible;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo(){
        return  titulo;
    }

    public String getAutor(){
        return  autor;
    }

    public Year getAnio(){
        return  anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setIsbn(String isbn){
        this.isbn=isbn;
    }

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnio(Year anio) {
        this.anio = anio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro[ISBN=" + isbn +
                "Título=" + titulo +
                "Autor=" + autor +
                "Año=" + anio +
                "Disponible=" + disponible + "]";
    }


}
