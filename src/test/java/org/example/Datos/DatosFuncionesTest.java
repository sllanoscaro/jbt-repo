package org.example.test;

import org.example.Datos.DatosFunciones;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class DatosFuncionesTest {
    @org.junit.jupiter.api.Test
    void escribirCSV() {
        String nombreArchivo = "src\\main\\resources\\datosFunciones.csv";
        String[] datos = {"Dato1", "Dato2", "Dato3","Dato4","Dato5","Dato6","Dato7"};

        DatosFunciones.escribirCSV(nombreArchivo, datos);
        assertTrue(Files.exists(Paths.get(nombreArchivo)));

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line = br.readLine();
            String[] datosEnArchivo = line.split(",");

            assertEquals(datos.length, datosEnArchivo.length);

            for (int i = 0; i < datos.length; i++) {
                assertEquals(datos[i], datosEnArchivo[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}