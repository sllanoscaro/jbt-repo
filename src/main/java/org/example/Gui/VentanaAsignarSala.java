package org.example.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Datos.DatosFunciones;
import org.example.Modelo.Funcion;
import org.example.Modelo.Sala;



public class VentanaAsignarSala extends JFrame {

    private JTextField numeroSalaField1;
    private JTextField horarioField2;

    private JLabel numeroSalaLabel;
    private JLabel horarioLabel;

    private JButton asignarButton;

    private String peliculaOriginal;


    public VentanaAsignarSala(Funcion funcion) {
        setTitle("Editar Datos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo la ventana de edición
        setLocationRelativeTo(null);




        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));




        asignarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String numeroSala = numeroSalaField1.getText();
                String horario = horarioField2.getText();
                Sala sala = new Sala(numeroSala,horario);


                if (numeroSala.isEmpty() ||horario.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DatosFunciones.guardarDatosFuncionesEnCSV(funcion,sala);
                dispose();
                VentanaFuncionesEditables ventanaFuncionesEditables = new VentanaFuncionesEditables();
            }
        });

        panel.add(horarioLabel);
        panel.add(horarioField2);
        panel.add(numeroSalaLabel);
        panel.add(numeroSalaField1);

        panel.add(asignarButton);

        add(panel);
        setVisible(true);
    }
}
