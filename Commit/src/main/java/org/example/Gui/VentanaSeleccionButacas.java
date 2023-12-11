package org.example.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VentanaSeleccionButacas extends JFrame {
    private static List<String> butacasSeleccionadas = new ArrayList<>(); // Hacer la lista estática
    private Properties properties;
    private JLabel peliculaLabel;
    private JLabel generoLabel;
    private JLabel directorLabel;
    private static final String PROPERTIES_FILE = "butacas.properties";
    private JPanel butacasPanel;
    private JButton confirmarCompraButton;

    public VentanaSeleccionButacas(String pelicula, String genero, String director) {
        setTitle("Selección de Butacas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);



        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4));
        panel.add(peliculaLabel);
        panel.add(generoLabel);
        panel.add(directorLabel);
        panel.add(butacasPanel);
        panel.add(confirmarCompraButton);

        add(panel);

        setVisible(true);
    }

}