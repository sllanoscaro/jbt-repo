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
}
