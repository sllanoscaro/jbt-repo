package org.example.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Datos.DatosFunciones;
import org.example.Modelo.Funcion;
import org.example.Modelo.Sala;

public class HacerResena extends JFrame {
    private JPanel panel;
    private JComboBox<Integer> comboBoxSeleccion;
    private JButton hacerResenaButton;

    public HacerResena(String pelicula, String genero, String director, String sinopsis, String clasificacion) {
        // Configuración de la ventana
        setTitle("Seleccionar Número");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        comboBoxSeleccion = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        hacerResenaButton = new JButton("Hacer Resena"); // Initialize the button

        // Agregar componentes al panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Selecciona cuantas estrellas le da a la pelicula: "));
        panel.add(comboBoxSeleccion);
        panel.add(hacerResenaButton);

        add(panel);

        setVisible(true);

        hacerResenaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroSeleccionado = String.valueOf(comboBoxSeleccion.getSelectedItem());
                Funcion funcion = new Funcion(pelicula, genero, director, sinopsis, clasificacion, numeroSeleccionado);
                Sala sala = new Sala("", "");
                DatosFunciones.guardarDatosResenas(funcion, sala);
                JOptionPane.showMessageDialog(null, "Se ha realizado la resena con exito!", "Resena", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }
}





