package org.example.Modelo;
public class Ticket {
    private Usuario usuario;
    private Funcion funcion;
    private Sala sala;

    public Ticket(Usuario usuario, Funcion funcion, Sala sala) {
        this.usuario = usuario;
        this.funcion = funcion;
        this.sala = sala;
    }
    public String nombreUsuario(){
        return usuario.getNombre();
    }
    public String nombrePelicula(){
        return funcion.getNombre();
    }
    public String salaPelicula(){
        return sala.getNumeroSala();
    }
    public String horarioPelicula(){
        return sala.getHorario();
    }
}
