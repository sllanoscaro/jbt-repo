package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.example.Datos.DatosFunciones;
import org.example.Modelo.Funcion;
import org.example.Modelo.Sala;

public class AgregarFuncion extends JFrame{
    private JPanel panel;
    private JButton crearPeliculaButton;
    private JTextField peliculaText;
    private JTextField generoText;
    private JTextField directorText;
    private JTextField sinopsisText;
    private JTextField clasificacionText;
    private JLabel peliculaLabel;
    private JLabel generoLabel;
    private JLabel directorLabel;
    private JLabel sinopsisLabel;
    private JLabel clasificacionLabel;


    public AgregarFuncion() {
        setTitle("Agregar Funcion");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Funcion funcion = new Funcion(peliculaText.getText(),directorText.getText(),generoText.getText(),sinopsisText.getText(),clasificacionText.getText());
        Sala sala = new Sala("","");
        DatosFunciones.guardarDatosPeliculasEnCSV(funcion,sala);






        add(panel);
        panel.add(peliculaLabel);
        panel.add(peliculaText);
        panel.add(directorLabel);
        panel.add(directorText);
        panel.add(generoLabel);
        panel.add(generoText);
        panel.add(sinopsisLabel);
        panel.add(sinopsisText);
        panel.add(clasificacionLabel);
        panel.add(clasificacionText);
        panel.add(crearPeliculaButton);



        setVisible(true);
}}
