package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Funcion> leerFuncionesDesdeCSV(String archivo) {
        List<Funcion> funciones = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0].trim();
                String genero = datos[1].trim();
                String director = datos[2].trim();
                String sinopsis = datos[3].trim();
                String clasificacion = datos[4].trim();

                Funcion funcion = new Funcion(nombre, genero, director, sinopsis, clasificacion);
                funciones.add(funcion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return funciones;
    }

    public static List<Sala> leerSalasDesdeCSV(String archivo) {
        List<Sala> salas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int numeroSala = Integer.parseInt(datos[0].trim());
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
    public static List<Usuario> leerUsuariosDesdeCSV(String archivo) {
        List<Usuario> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0].trim();
                String contraseña = datos[1].trim();

                Usuario user = new Usuario(nombre, contraseña);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }


    public static void main(String[] args) {
            List<Funcion> funciones = leerFuncionesDesdeCSV("src\\main\\resources\\funciones.csv");
            List<Sala> salas = leerSalasDesdeCSV("src\\main\\resources\\salas.csv");
            List<Usuario> usuarios = leerUsuariosDesdeCSV("src\\main\\resources\\usuarios.csv"); // Asegúrate de tener un archivo CSV con usuarios

            // Asignar salas a funciones según la relación que tengas en tus datos
            funciones.get(0).agregarSala(salas.get(0));
            funciones.get(1).agregarSala(salas.get(1));
            funciones.get(2).agregarSala(salas.get(2));

            // Puedes imprimir la información de las funciones y salas para verificar que se haya leído correctamente
            for (Funcion funcion : funciones) {
                System.out.println("Función: " + funcion.getNombre());
                for (Sala sala : funcion.getSalas()) {
                    System.out.println("Sala: " + sala.getNumeroSala() + ", Horario: " + sala.getHorario());
                }
            }

            // Puedes imprimir la información de los usuarios para verificar que se hayan leído correctamente
            System.out.println("\nUsuarios:");
            for (Usuario usuario : usuarios) {
                System.out.println("Usuario: " + usuario.getNombre() + ", Contraseña: " + usuario.getContraseña());
            }
        }


}
