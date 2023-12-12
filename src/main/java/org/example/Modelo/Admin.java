package org.example.Modelo;

public class Admin {

    private String nombre = "admin";

    private String clave = "1234";
    private boolean privilegios = true;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


}