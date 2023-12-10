package org.example.Datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;


import org.example.Modelo.Funcion;
import org.example.Modelo.Usuario;
import org.example.Modelo.Admin;
public interface DatosFunciones {
    static void guardarDatosEnCSV(Funcion funcion) {
        String[] datos = {funcion.getNombre(), funcion.getGenero(),funcion.getDirector(),funcion.getSinopsis(),funcion.getClasificacion()};
        escribirCSV("datosFunciones.csv", datos);
        System.out.println("Datos guardados en datos.csv");
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
    static DefaultTableModel mostrarDatosCSV(DefaultTableModel model){
        try (BufferedReader br = new BufferedReader(new FileReader("funciones.csv"))) {
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
    static void actualizarDatosCSV(String peliculaOriginal, String nuevaPelicula, String nuevoGenero, String nuevoDirector, String nuevaSinopsis, String nuevaClasificacion) {
        String nombreArchivo = "funciones.csv";
        String lineaActual;
        String[] datos;
        StringBuilder nuevoContenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            while ((lineaActual = br.readLine()) != null) {
                datos = lineaActual.split(",");
                if (datos.length > 0 && datos[0].equals(peliculaOriginal)) {
                    nuevoContenido.append(nuevaPelicula).append(",").append(nuevoGenero).append(",").append(nuevoDirector).append(",").append(nuevaSinopsis).append(",").append(nuevaClasificacion).append("\n");
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
