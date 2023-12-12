package org.example.Modelo;

import javax.swing.table.DefaultTableModel;

public class Calculadora {

    public Calculadora() {
    }

    public int calcularPrecioTickets(DefaultTableModel model, int multiplicador){
        return model.getRowCount()*multiplicador;
    }

}
