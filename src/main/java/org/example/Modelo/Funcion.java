package org.example.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Funcion {
    private String nombre;

    private String genero;

    private String director;
    private String sinopsis;


    private String clasificacion;
    private float rating;
    private List<Sala> salas;



    public Funcion(String nombre, String genero, String director, String sinopsis, String clasificacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.director = director;
        this.sinopsis = sinopsis;
        this.clasificacion = clasificacion;
        this.salas = new ArrayList<>();
    }
    public void agregarSala(Sala sala) {
        salas.add(sala);
    }
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

    public  boolean[][] reservarAsiento(boolean[][] matriz, int columna, char fila) {
        if (columna >= 1 && columna <= matriz.length && fila >= 'A' && fila < 'A' + matriz[0].length) {
            int columnaIndex = columna - 1;
            int filaIndex = fila - 'A';
            if (matriz[filaIndex][columnaIndex] != true) {
                matriz[filaIndex][columnaIndex] = true;
                System.out.println("¡Compra exitosa! Ha comprado el asiento " + columna + fila);
            } else {
                System.out.println("Este asiento ya está ocupado. Por favor, seleccione otro.");
            }
        } else {
            System.out.println("Ubicación de asiento no válida. Por favor, ingrese una ubicación válida.");
        }
        return matriz;
    }
    public String[][] marcarAsientoOcupado(String[][] matriz, int columna, char fila) {
        if (columna >= 1 && columna <= matriz[0].length && fila >= 'A' && fila < 'A' + matriz.length) {
            // Convertir la fila a índice de matriz
            int columnaIndex = columna - 1;
            int filaIndex = fila - 'A';

            if (!matriz[filaIndex][columnaIndex].equals("X")) {
                matriz[filaIndex][columnaIndex] = "X"; // Marcar el asiento como ocupado
                System.out.println("¡Compra exitosa! Ha comprado el asiento " + columna + fila);
            } else {
                System.out.println("Este asiento ya está ocupado. Por favor, seleccione otro.");
            }
        } else {
            System.out.println("Ubicación de asiento no válida. Por favor, ingrese una ubicación válida.");
        }
        return matriz;
    }




}




