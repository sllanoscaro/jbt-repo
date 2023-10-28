package org.example;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Usuario usuario = new Usuario();
        Usuario usuario1 = new Usuario();
        usuario.crearCuenta("Arturo","123456");



        if (usuario.iniciarSesion("Arturooo", "123456")) {
            System.out.println("Inicio de sesión exitoso como usuario.");
        }
        else if(admin.iniciarSesion("adminnn", "1234")){
            System.out.println("Inicio de sesión exitoso como administrador.");
        }
        else {
            System.out.println("Inicio de sesión fallido.");
        }
        }
    }
