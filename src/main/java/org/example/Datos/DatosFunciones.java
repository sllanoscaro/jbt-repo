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

    /**
     * Escribe en datosFunciones.csv los datos de Funciones y Salas
     * @param funcion se entrega una funcion y se escriben por separado cada atributo
     * @param sala se entrega una sala y se escriben por separado cada atributo
     */
    static void guardarDatosFuncionesEnCSV(Funcion funcion, Sala sala) {
        String[] datos = {funcion.getNombre(), funcion.getGenero(),funcion.getDirector(),funcion.getSinopsis(),funcion.getClasificacion(),sala.getNumeroSala(),sala.getHorario(),funcion.getRating()};
        escribirCSV("src\\main\\resources\\datosFunciones.csv", datos);
        System.out.println("Datos guardados en datosFunciones.csv");
    }
    /**
     * Escribe en peliculas.csv los datos de Funciones y Salas
     * @param funcion se entrega una funcion y se escriben por separado cada atributo
     * @param sala se entrega una sala y se escriben por separado cada atributo
     */
    static void guardarDatosPeliculasEnCSV(Funcion funcion, Sala sala) {
        String[] datos = {funcion.getNombre(), funcion.getGenero(),funcion.getDirector(),funcion.getSinopsis(),funcion.getClasificacion(),sala.getNumeroSala(),sala.getHorario(),funcion.getRating()};
        escribirCSV("src\\main\\resources\\peliculas.csv", datos);
        System.out.println("Datos guardados en peliculas.csv");
    }

    /**
     * Escribe en peliculas.csv los datos de Funciones y Salas
     * @param nombre se registra el nombre del usuario que hizo la resena
     * @param funcion se entrega una funcion y se escriben por separado cada atributo
     * @param sala se entrega una sala y se escriben por separado cada atributo
     */
    static void guardarDatosResenas(String nombre, Funcion funcion, Sala sala) {
        String[] datos = {nombre,funcion.getNombre(), funcion.getGenero(),funcion.getDirector(),funcion.getSinopsis(),funcion.getClasificacion(),sala.getNumeroSala(),sala.getHorario(),funcion.getRating()};
        escribirCSV("src\\main\\resources\\resenas.csv", datos);
        System.out.println("Datos guardados en resenas.csv");
    }


    /**
     * Escribe los datos en el csv ingresado
     * @param nombreArchivo recibe el nombre del archivo para ingresar los datos
     * @param datos recibe los datos ingresados para
     */
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

    /**
     * Muestra los datos de datosFunciones.csv
     * @param model muestra los datos del modelo
     * @return
     */
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
    /**
     * Muestra los datos de peliculas.csv
     * @param model muestra los datos del modelo
     * @return
     */
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
    /**
     * Muestra los datos de tickets.csv
     * @param model muestra los datos del modelo
     * @return
     */
    static DefaultTableModel mostrarTicketsUsuariosCSV(DefaultTableModel model){
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
    /**
     * Muestra los datos de resenas.csv
     * @param model muestra los datos del modelo
     * @return
     */
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

    /**
     * filtra las funciones por nombre
     * @param userName recibe el nombre para que filtre las peliculas
     * @param model recibe todas las funciones
     * @return
     */
    static DefaultTableModel filtrarFilasPorNombre(String userName, DefaultTableModel model) {
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            String currentUserName = (String) model.getValueAt(i, 0);
            if (!currentUserName.equals(userName)) {
                model.removeRow(i);
            }
        }
        return model;
    }

    /**
     * Actualiza los datos permitiendo editarlos
     * @param peliculaOriginal pelicula a editar
     * @param nuevaPelicula nueva pelicula
     * @param nuevoGenero nuevo genero
     * @param nuevoDirector nuevo director
     * @param nuevaSinopsis nueva sinopsis
     * @param nuevaClasificacion nueva clasificacion
     * @param numeroSala nuevo numero sala
     * @param horario nuevo horario
     */
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
