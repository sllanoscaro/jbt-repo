package logica;

import logica.Funcion;

public class Ticket {
    private Usuario usuario;
    private Funcion funcion;
    private String asiento;

    public Ticket(Usuario usuario, Funcion funcion, String asiento) {
        this.usuario = usuario;
        this.funcion = funcion;
        this.asiento = asiento;
    }

    public String nombreUsuario(){
        return usuario.getNombre();
    }
    public String nombrePelicula(){
        return funcion.getNombre();
    }

}
