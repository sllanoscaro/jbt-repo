package org.example;

class Admin {
    private String nombre = "admin";
    private String clave = "1234";
    private boolean privilegios = true;

    public boolean iniciarSesion(String nombre, String clave) {
        return this.nombre.equals(nombre) && this.clave.equals(clave);
    }
}