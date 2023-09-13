package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su usuario: ");
        String user = scanner.next();
        System.out.println("Ingrese su contraseña: ");
        String password = scanner.next();
        System.out.println(inicioSesion(user, password));
        String [][] salaCine;
        salaCine = generarSalaCine(15,15);
        mostrarAsientosCine(salaCine);
    }
    public static boolean inicioSesion(String user, String password){
        String usuario = "Carlos";
        String clave = "admincine123";
        if (usuario.equals(user) && password.equals(clave)){
            return true;
        }
        return false;
    }
    public static String[][] generarSalaCine(int filas, int columnas) {
        String[][] matriz = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (j + 1) + Character.toString((char) ('a' + i));
            }
        }
        return matriz;
    }
    public static void mostrarAsientosCine(String[][] matriz) {
        System.out.println("Los asientos disponibles son: ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("|" + matriz[i][j] + "|");
            }
            System.out.println();
        }
    }

}