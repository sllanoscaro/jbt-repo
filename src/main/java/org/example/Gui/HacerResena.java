package org.example.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Datos.DatosFunciones;
import org.example.Modelo.Funcion;
import org.example.Modelo.Sala;

public class HacerResena extends JFrame {
    private JPanel panel;
    private JButton hacerResenaButton;
    private JTextField resenaTextField;
    private JLabel resenaLabel;

    public HacerResena(String nombre, String pelicula, String genero, String director, String sinopsis, String clasificacion) {
        setTitle("Haz tu reseña");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);



        String resena = resenaTextField.getText();


        JPanel panel = new JPanel();

        panel.add(resenaLabel);
        panel.add(resenaTextField);
        panel.add(hacerResenaButton);

        panel.setLayout(new GridLayout(2, 2, 10, 10));


        add(panel);

        setVisible(true);

        /**
         * guarda los datos recibidos en resenas.csv
         */
        hacerResenaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (resenaTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Funcion funcion = new Funcion(pelicula, genero, director, sinopsis, clasificacion, resenaTextField.getText());
                Sala sala = new Sala("", "");
                DatosFunciones.guardarDatosResenas(nombre, funcion, sala);
                JOptionPane.showMessageDialog(null, "Se ha realizado la reseña con exito!", "Reseña", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                FuncionesParaResenas funcionesParaResenas = new FuncionesParaResenas(nombre);
            }
        });
    }
}





