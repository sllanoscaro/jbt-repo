package logica;

import Gui.SalaCineGUI;
import logica.Funcion;
import logica.Sala;

import javax.swing.*;
import java.util.List;

import static logica.CSVReader.leerFuncionesDesdeCSV;
import static logica.CSVReader.leerSalasDesdeCSV;

public class Main {
    public static void main(String[] args) {
        List<Funcion> funciones = leerFuncionesDesdeCSV("src\\main\\resources\\funciones.csv");
        List<Sala> salas = leerSalasDesdeCSV("src\\main\\resources\\salas.csv");
        SalaCineGUI sala = new SalaCineGUI(salas.get(1));

        }



}
