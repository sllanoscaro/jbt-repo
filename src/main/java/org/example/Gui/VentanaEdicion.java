package org.example.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Datos.DatosFunciones;


public class VentanaEdicion extends JFrame {

    private JTextField peliculaField1;
    private JTextField generoField2;
    private JTextField directorField3;
    private JTextField sinopsisField4;
    private JTextField clasificacionField5;
    private JLabel peliculaLabel;
    private JLabel generoLabel;
    private JLabel directorLabel;
    private JLabel sinopsisLabel;
    private JLabel clasificacionLabel;
    private JLabel vacio;
    private JButton guardarButton;

    private String peliculaOriginal;



    public VentanaEdicion(String pelicula, String genero, String director, String sinopsis, String clasificacion) {
        setTitle("Editar Datos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo la ventana de edición
        setLocationRelativeTo(null);

        peliculaOriginal = pelicula;


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));




        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevaPelicula = peliculaField1.getText();
                String nuevoGenero = generoField2.getText();
                String nuevoDirector = directorField3.getText();
                String nuevaSinopsis = sinopsisField4.getText();
                String nuevaClasificacion = clasificacionField5.getText();
                if (nuevaPelicula.isEmpty() ||nuevoGenero.isEmpty()||nuevoDirector.isEmpty()||nuevaSinopsis.isEmpty()||nuevaClasificacion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DatosFunciones.actualizarDatosCSV(peliculaOriginal, nuevaPelicula, nuevoGenero, nuevoDirector, nuevaSinopsis, nuevaClasificacion);
                dispose();
                VentanaFuncionesEditables ventanaFuncionesEditables = new VentanaFuncionesEditables();
            }
        });

        panel.add(peliculaLabel);
        panel.add(peliculaField1);
        panel.add(generoLabel);
        panel.add(generoField2);
        panel.add(directorLabel);
        panel.add(directorField3);
        panel.add(sinopsisLabel);
        panel.add(sinopsisField4);
        panel.add(clasificacionLabel);
        panel.add(clasificacionField5);
        panel.add(guardarButton);

        add(panel);
        setVisible(true);
    }
}
