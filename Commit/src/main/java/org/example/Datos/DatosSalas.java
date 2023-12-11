package org.example.Datos;

import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.example.Modelo.Sala;

public interface DatosSalas {
    static final String RUTA_ARCHIVO = "src\\main\\resources\\salas.csv";

        static void mostrarDatosCSV(DefaultTableModel model) {
            BufferedReader br = null;

            try {
                br = new BufferedReader(new FileReader(RUTA_ARCHIVO));
                String line;

                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    model.addRow(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    public static List<Sala> leerSalasDesdeCSV(String archivo) {
        List<Sala> salas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String numeroSala = datos[0].trim();
                String horario = datos[1].trim();
                String[] butacasString = datos[2].split(",");
                boolean[][] butacas = new boolean[12][12];

                for (int i = 0; i < butacasString.length; i++) {
                    butacas[i / 12][i % 12] = Boolean.parseBoolean(butacasString[i].trim());
                }

                Sala sala = new Sala(numeroSala, horario);
                sala.setButacas(butacas);
                salas.add(sala);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return salas;
    }
    }


