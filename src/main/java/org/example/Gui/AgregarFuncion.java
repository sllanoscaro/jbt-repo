package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.example.Datos.DatosFunciones;
import org.example.Modelo.Funcion;
import org.example.Modelo.Sala;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        panel.setLayout(new GridLayout(6, 2));

        /**
         * obtiene el texto de los TextField  y los guarda en peliculas.csv
         */
        crearPeliculaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (peliculaText.getText().isEmpty() || directorText.getText().isEmpty()|| generoText.getText().isEmpty()|| sinopsisText.getText().isEmpty()|| clasificacionText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Funcion funcion = new Funcion(peliculaText.getText(),generoText.getText(),directorText.getText(),sinopsisText.getText(),clasificacionText.getText(),"");
                Sala sala = new Sala("","");
                DatosFunciones.guardarDatosPeliculasEnCSV(funcion,sala);
                VentanaFuncionesEditables ventanaFuncionesEditables = new VentanaFuncionesEditables();
                dispose();

            }
        });




        panel.add(peliculaLabel);
        panel.add(peliculaText);
        panel.add(generoLabel);
        panel.add(generoText);
        panel.add(directorLabel);
        panel.add(directorText);
        panel.add(sinopsisLabel);
        panel.add(sinopsisText);
        panel.add(clasificacionLabel);
        panel.add(clasificacionText);
        panel.add(crearPeliculaButton);

        panel.setLayout(new GridLayout(6, 2)); // Use an appropriate layout manager

        add(panel);
        setVisible(true);
}}
