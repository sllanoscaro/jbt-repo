package org.example.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Funcion {
    private String nombre;

    private String genero;

    private String director;
    private String sinopsis;


    private String clasificacion;


    private String rating;



    private List<Sala> salas;



    public Funcion(String nombre, String genero, String director, String sinopsis, String clasificacion, String rating) {
        this.nombre = nombre;
        this.genero = genero;
        this.director = director;
        this.sinopsis = sinopsis;
        this.clasificacion = clasificacion;
        this.rating =rating;
        this.salas = new ArrayList<>();
    }
    public void agregarSala(Sala sala) {
        salas.add(sala);
    }
    public static List<Funcion> listaFunciones = new ArrayList<>();
    public String getNombre() {
        return nombre;
    }
    public String getGenero() {
        return genero;
    }
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Sala> getSalas() {
        return salas;
    }
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }







}




