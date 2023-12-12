package org.example.Modelo;



public class Sala {
    private String  numeroSala;
    private String horario;
    private boolean[][] butacas = new boolean[12][12];

    public Sala(String numeroSala, String horario) {
        this.numeroSala = numeroSala;
        this.horario = horario;
    }

    public boolean[][] getButacas() {
        return butacas;
    }

    public String  getNumeroSala() {
        return numeroSala;
    }

    public String getHorario() {
        return horario;
    }

    public void setButacas(boolean[][] butacas) {
        this.butacas = butacas;
    }
}


