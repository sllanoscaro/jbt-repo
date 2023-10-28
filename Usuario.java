package org.example;

class Usuario {


    private String nombre;
    private String clave;
    private boolean privilegios = false;
    private  String[] peliculasFav;

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

    public Usuario() {
    }

    public boolean iniciarSesion(String nombre, String clave) {
        if (this.nombre != null && this.clave != null) {
            return this.nombre.equals(nombre) && this.clave.equals(clave);
        }
        return false;
    }

    public void crearCuenta(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }
}