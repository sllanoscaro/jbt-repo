package org.example.Modelo;

import javax.swing.table.DefaultTableModel;

public class Calculadora {

    public Calculadora() {
    }

    /**
     * calcula el precio de los tickets
     * @param model recibe el model de la tabla
     * @param multiplicador recibe el numero a multiplicar
     * @return
     */
    public int calcularPrecioTickets(DefaultTableModel model, int multiplicador){
        return model.getRowCount()*multiplicador;
    }

}
