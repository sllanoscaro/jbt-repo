package org.example.Datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.example.Modelo.Usuario;
import org.example.Modelo.Admin;


public interface Datos {

    static void guardarDatosEnCSV(Usuario usuario) {
        String[] datos = {usuario.getNombre(), usuario.getClave()};
        escribirCSV("datos.csv", datos);
        System.out.println("Datos guardados en datos.csv");
    }

    static void guardarDatosAdminEnCSV(Admin admin) {
        boolean adminEncontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos[0].equals(admin.getNombre()) && datos[1].equals(admin.getClave())) {
                    adminEncontrado = true;
                    System.out.println("Admin encontrado");
                    break;
                }
            }

            if (!adminEncontrado) {
                System.out.println("Admin no encontrado. Creando nuevo...");
                String[] datosadmin = {admin.getNombre(), admin.getClave()};
                escribirCSV("datos.csv", datosadmin);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    static boolean buscarUsuarioyClave(String usuarioBuscado, String claveBuscado) {
        boolean permisos = true;
        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(usuarioBuscado)&& datos[1].equals(claveBuscado)) {

                    System.out.println("Usuario encontrado:");
                    System.out.println("Usuario: " + datos[0]);
                    System.out.println("Clave: " + datos[1]);
                    permisos = true;
                    return permisos;
                }
            }
            permisos = false;


            System.out.println("Usuario no encontrado con Usuario: " + usuarioBuscado);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return permisos;
    }
    static boolean buscarUsuarioOAdmin(String usuarioBuscado, String claveBuscado) {
        boolean permisos = true;
        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (usuarioBuscado.equals("admin")&& claveBuscado.equals("1234")) {

                    System.out.println("Usuario encontrado:");
                    System.out.println("Usuario: " + datos[0]);
                    System.out.println("Clave: " + datos[1]);
                    permisos = true;
                    return permisos;
                }
                else if (datos[0].equals(usuarioBuscado) && datos[1].equals(claveBuscado)){
                    permisos = false;
                    return permisos;
                }
            }
            System.out.println("Usuario no encontrado con Usuario: " + usuarioBuscado);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return permisos;
    }


    static void cambiarEstadoPrestadoPorID(String idBuscado, String nuevoEstado) {
        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) {
            String linea;
            StringBuilder nuevoContenido = new StringBuilder();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length > 0 && datos[0].equals(idBuscado)) {
                    datos[1] = nuevoEstado;
                    System.out.println("El estado prestado de la ID ingresada ha sido cambiado");
                }
                nuevoContenido.append(String.join(",", datos)).append("\n");
            }
            try (FileWriter writer = new FileWriter("datos.csv")) {
                writer.write(nuevoContenido.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}