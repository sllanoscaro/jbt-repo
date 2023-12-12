package org.example.Gui;

import org.example.Modelo.Sala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VentanaSeleccionButacas extends JFrame {
    private Sala sala;
    private List<JButton> selectedSeats;


    public VentanaSeleccionButacas(Sala sala, String nombre) {
        this.sala = sala;
        this.selectedSeats = new ArrayList<>();
        initComponents(nombre);
    }

    private void initComponents(String nombre) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sala de Cine - Sala " + sala.getNumeroSala() + " - Horario: " + sala.getHorario());

        JPanel panel = new JPanel(new GridLayout(13, 12, 5, 5));

        panel.add(new JLabel());
        for (char c = 'A'; c <= 'L'; c++) {
            panel.add(new JLabel(String.valueOf(c), SwingConstants.CENTER));
        }

        for (int i = 0; i < sala.getButacas().length; i++) {

            panel.add(new JLabel(String.valueOf(i + 1), SwingConstants.CENTER));

            for (int j = 0; j < sala.getButacas()[i].length; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(40, 40));

                if (sala.getButacas()[i][j]) {
                    button.setBackground(Color.RED);
                    button.setEnabled(false);
                } else {
                    button.setBackground(Color.GREEN);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            toggleSeatSelection(button);
                        }
                    });
                }

                panel.add(button);
            }
        }

        JButton confirmButton = new JButton("Comprar");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmSelection(nombre);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void toggleSeatSelection(JButton button) {
        if (selectedSeats.contains(button)) {
            // Desseleccionar el asiento
            button.setBackground(Color.GREEN);
            selectedSeats.remove(button);
        } else {

            button.setBackground(Color.YELLOW);
            selectedSeats.add(button);
        }
    }

    private void confirmSelection(String nombre) {
        if (selectedSeats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona al menos un asiento antes de confirmar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String salaInfo = "Sala " + sala.getNumeroSala() + " - Horario: " + sala.getHorario();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/tickets.csv", true))) {
            for (JButton button : selectedSeats) {
                int row = (button.getY() - 2) / (button.getHeight() + 5);
                int col = (button.getX() - 2) / (button.getWidth() + 5);

                String seat = "(" + (row + 1) + "-" + (char) ('A' + col) + ")";

                // Actualizar el booleano de la sala
                sala.getButacas()[row][col] = true;

                // Escribir la información en el archivo CSV
                writer.write(nombre + "," + seat + "," + salaInfo);
                writer.newLine();

                // Actualizar el color del botón (puedes cambiarlo según sea necesario)
                button.setBackground(Color.RED);
                button.setEnabled(false);
            }

            // Limpiar la lista de asientos seleccionados
            selectedSeats.clear();

            // Mostrar el mensaje con los asientos comprados
            JOptionPane.showMessageDialog(this, "Compra Exitosa", "Compra Exitosa", JOptionPane.INFORMATION_MESSAGE);

            // Cerrar la ventana
            dispose();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la información en el archivo CSV.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
