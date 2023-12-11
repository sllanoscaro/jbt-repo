package org.example.Modelo;



public class Sala {
    private String  numeroSala;
    private String horario;
    private boolean[][] butacas = new boolean[12][12];

    public Sala(String numeroSala, String horario) {
        this.numeroSala = numeroSala;
        this.horario = horario;
    }
    public String[][] generarSaladeCine() {
        String[][] matriz = new String[12][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                matriz[i][j] = (j + 1) + Character.toString((char) ('A' + i));
            }
        }
        return matriz;
    }
    public void mostrarSalaCine(String[][]sala){
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                System.out.print(sala[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void mostrarBooleanoSala(){
        for (int i = 0; i < this.butacas.length; i++) {
            for (int j = 0; j < this.butacas[i].length; j++) {
                System.out.print(this.butacas[i][j] + " ");
            }
            System.out.println();
        }
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


