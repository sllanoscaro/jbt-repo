package org.example.Datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


import org.example.Modelo.Funcion;
import org.example.Modelo.Usuario;
import org.example.Modelo.Sala;

import org.example.Modelo.Admin;
public interface DatosFunciones {
    static void guardarDatosFuncionesEnCSV(Funcion funcion, Sala sala) {
        String[] datos = {funcion.getNombre(), funcion.getGenero(),funcion.getDirector(),funcion.getSinopsis(),funcion.getClasificacion(),sala.getNumeroSala(),sala.getHorario(),funcion.getRating()};
        escribirCSV("src\\main\\resources\\datosFunciones.csv", datos);
        System.out.println("Datos guardados en datosFunciones.csv");
    }
    static void guardarDatosPeliculasEnCSV(Funcion funcion, Sala sala) {
        String[] datos = {funcion.getNombre(), funcion.getGenero(),funcion.getDirector(),funcion.getSinopsis(),funcion.getClasificacion(),sala.getNumeroSala(),sala.getHorario(),funcion.getRating()};
        escribirCSV("src\\main\\resources\\peliculas.csv", datos);
        System.out.println("Datos guardados en peliculas.csv");
    }
    static void guardarDatosResenas(String nombre, Funcion funcion, Sala sala) {
        String[] datos = {nombre,funcion.getNombre(), funcion.getGenero(),funcion.getDirector(),funcion.getSinopsis(),funcion.getClasificacion(),sala.getNumeroSala(),sala.getHorario(),funcion.getRating()};
        escribirCSV("src\\main\\resources\\resenas.csv", datos);
        System.out.println("Datos guardados en resenas.csv");
    }

    static void escribirCSV(String nombreArchivo, String[] datos) {
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            for (String dato : datos) {
                writer.append(dato).append(",");
            }
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static DefaultTableModel mostrarDatosFuncionesCSV(DefaultTableModel model){
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\datosFunciones.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }
    static DefaultTableModel mostrarDatosCSV(DefaultTableModel model){
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\peliculas.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }
    static DefaultTableModel mostrarResenasCSV(DefaultTableModel model){
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\resenas.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }
    static DefaultTableModel mostrarTicketsCSV(DefaultTableModel model){
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\tickets.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }
    static void actualizarDatosCSV(String peliculaOriginal, String nuevaPelicula, String nuevoGenero, String nuevoDirector, String nuevaSinopsis, String nuevaClasificacion, String numeroSala, String horario) {
        String nombreArchivo = "src\\main\\resources\\peliculas.csv";
        String lineaActual;
        String[] datos;
        StringBuilder nuevoContenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            while ((lineaActual = br.readLine()) != null) {
                datos = lineaActual.split(",");
                if (datos.length > 0 && datos[0].equals(peliculaOriginal)) {
                    nuevoContenido.append(nuevaPelicula).append(",").append(nuevoGenero).append(",").append(nuevoDirector).append(",").append(nuevaSinopsis).append(",").append(nuevaClasificacion).append(",").append(numeroSala).append(",").append(horario).append("\n");
                } else {
                    nuevoContenido.append(lineaActual).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(nuevoContenido.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
