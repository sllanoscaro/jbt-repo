package org.example.Gui;

import org.example.Modelo.Sala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaSeleccionButacas extends JFrame {
    private Sala sala;
    private List<JButton> selectedSeats;


    public VentanaSeleccionButacas(Sala sala) {
        this.sala = sala;
        this.selectedSeats = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sala de Cine - Sala " + sala.getNumeroSala() + " - Horario: " + sala.getHorario());

        JPanel panel = new JPanel(new GridLayout(13, 12, 5, 5)); // Añadimos una fila adicional para las letras

        // Agregamos una fila de letras en la parte superior
        panel.add(new JLabel());
        for (char c = 'A'; c <= 'L'; c++) {
            panel.add(new JLabel(String.valueOf(c), SwingConstants.CENTER));
        }

        for (int i = 0; i < sala.getButacas().length; i++) {
            // Agregamos el número de fila a la izquierda
            panel.add(new JLabel(String.valueOf(i + 1), SwingConstants.CENTER));

            for (int j = 0; j < sala.getButacas()[i].length; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(40, 40));

                if (sala.getButacas()[i][j]) {
                    button.setBackground(Color.RED); // Asiento ocupado
                    button.setEnabled(false);
                } else {
                    button.setBackground(Color.GREEN); // Asiento disponible
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
                confirmSelection();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    private void toggleSeatSelection(JButton button) {
        if (selectedSeats.contains(button)) {
            // Desseleccionar el asiento
            button.setBackground(Color.GREEN);
            selectedSeats.remove(button);
        } else {
            // Seleccionar el asiento
            button.setBackground(Color.YELLOW); // Puedes cambiar a otro color para indicar selección
            selectedSeats.add(button);
        }
    }

    private void confirmSelection() {
        if (selectedSeats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona al menos un asiento antes de confirmar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder message = new StringBuilder("Asientos comprados: ");
        for (JButton button : selectedSeats) {
            int row = (button.getY() - 2) / (button.getHeight() + 5);
            int col = (button.getX() - 2) / (button.getWidth() + 5);

            // Actualizar el booleano de la sala
            sala.getButacas()[row][col] = true;

            // Construir el mensaje con los números de asientos comprados
            message.append("(").append(row + 1).append("-").append((char) ('A' + col)).append(") ");

            // Actualizar el color del botón (puedes cambiarlo según sea necesario)
            button.setBackground(Color.RED);
            button.setEnabled(false);
        }

        // Limpiar la lista de asientos seleccionados
        selectedSeats.clear();

        // Mostrar el mensaje con los asientos comprados
        JOptionPane.showMessageDialog(this, message.toString(), "Compra Exitosa", JOptionPane.INFORMATION_MESSAGE);

        // Cerrar la ventana
        dispose();
    }

}
