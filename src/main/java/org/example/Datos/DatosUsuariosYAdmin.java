package org.example.Datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.example.Modelo.Usuario;
import org.example.Modelo.Admin;

import javax.swing.table.DefaultTableModel;


public interface DatosUsuariosYAdmin {

    /**
     * Guarda los datos de usuario en un csv
     * @param usuario recibe un usuario y los separa por nombre y clave
     */
    static void guardarDatosEnCSV(Usuario usuario) {
        String[] datos = {usuario.getNombre(), usuario.getClave()};
        escribirCSV("src\\main\\resources\\datosUsuarios.csv", datos);
        System.out.println("Datos guardados en datosUsuarios.csv");
    }

    /**
     * revisa si existe una cuenta admin en el csv y si no existe la crea
     * @param admin recibe un admin y los separa por usuario y clave
     */
    static void guardarDatosAdminEnCSV(Admin admin) {
        boolean adminEncontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\datosUsuarios.csv"))) {
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
                escribirCSV("src\\main\\resources\\datosUsuarios.csv", datosadmin);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Escribe un csv con el nombre de archivo entregado y la lista de datos
     * @param nombreArchivo recibe el nombre de archivo
     * @param datos recibe los datos
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
     * busca el usuario si esta en datosUsarios.csv
     * @param usuarioBuscado el usuario que busca
     * @param claveBuscado la clave que busca
     * @return
     */
    static boolean buscarUsuarioyClave(String usuarioBuscado, String claveBuscado) {
        boolean permisos = true;
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\datosUsuarios.csv"))) {
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

    /**
     * busca si existe un admin en datosUsuarios.csv
     * @param usuarioBuscado usuario buscado
     * @param claveBuscado clave buscada
     * @return
     */
    static boolean buscarUsuarioOAdmin(String usuarioBuscado, String claveBuscado) {
        boolean permisos = true;
        Admin admin = new Admin();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\datosUsuarios.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (usuarioBuscado.equals(admin.getNombre()) && claveBuscado.equals(admin.getClave()) && datos.length >= 2) {
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

    /**
     * busca el usuario por nombre para ver si ya existe una cuenta creada por ese nombre
     * @param usuarioBuscado el nombre del usuario que se busca
     * @return
     */
    static boolean buscarUsuarioPorNombre(String usuarioBuscado) {
        boolean usuarioEncontrado = false;
        Admin admin = new Admin();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\datosUsuarios.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (usuarioBuscado.equals(admin.getNombre()) && datos.length >= 2) {
                    usuarioEncontrado = true;
                    return usuarioEncontrado;
                } else if (datos[0].equals(usuarioBuscado)) {
                    usuarioEncontrado = true;
                    return usuarioEncontrado;
                }
            }
            System.out.println("Usuario no encontrado con Usuario: " + usuarioBuscado);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarioEncontrado;
    }


    /**
     * muestra los datos de datosUsuarios.csv
     * @param model el table model que recibe para mostrar los datos
     * @return
     */
    static DefaultTableModel mostrarDatosCSV(DefaultTableModel model){
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\datosUsuarios.csv"))) {
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

}