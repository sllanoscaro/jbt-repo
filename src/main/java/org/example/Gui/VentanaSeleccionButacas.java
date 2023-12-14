package org.example.Gui;

import org.example.Datos.DatosFunciones;
import org.example.Modelo.Sala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaSeleccionButacas extends JFrame {
    private Sala sala;
    private List<JButton> asientoSeleccionado;

    /**
     * Constructor
     *
     * @param sala
     * @param nombre
     * @param pelicula
     */
    public VentanaSeleccionButacas(Sala sala, String nombre, String pelicula) {
        this.sala = sala;
        this.asientoSeleccionado = new ArrayList<>();
        inicializarComponentes(nombre, pelicula);
    }

    /**
     * crea la ventana con las butacas para seleccionar y comprar
     *
     * @param nombre   nombre asignado
     * @param pelicula pelicula asignada
     */
    private void inicializarComponentes(String nombre, String pelicula) {
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

                // Get the seat information for the current button
                String currentSeat = "(" + (i + 1) + "-" + (char) ('A' + j) + ")";

                // Check if the current seat is in the filtered CSV data
                List<String[]> csvDataList = DatosFunciones.csvAuxiliiar(sala.getNumeroSala(), sala.getHorario(), pelicula);
                boolean seatOccupied = csvDataList.stream().anyMatch(data -> data[2].equals(currentSeat));

                if (seatOccupied || sala.getButacas()[i][j]) {
                    button.setBackground(Color.RED);
                    button.setEnabled(false);
                } else {
                    button.setBackground(Color.GREEN);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            seleccionDeAsiento(button);
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
                confirmarSeleccion(nombre, pelicula);
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

    private void seleccionDeAsiento(JButton button) {
        if (asientoSeleccionado.contains(button)) {
            button.setBackground(Color.GREEN);
            asientoSeleccionado.remove(button);
        } else {
            button.setBackground(Color.YELLOW);
            asientoSeleccionado.add(button);
        }
    }

    private void confirmarSeleccion(String nombre, String pelicula) {
        String seat = "";

        if (asientoSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona al menos un asiento antes de confirmar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String salaInfo = "Sala " + sala.getNumeroSala() + " - Horario: " + sala.getHorario();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/tickets.csv", true))) {
            for (JButton button : asientoSeleccionado) {
                int row = (button.getY() - 2) / (button.getHeight() + 5);
                int col = (button.getX() - 2) / (button.getWidth() + 5);

                seat = "(" + (row + 1) + "-" + (char) ('A' + col) + ")";
                sala.getButacas()[row][col] = true;

                writer.write(nombre + "," + pelicula + "," + seat + "," + salaInfo);
                writer.newLine();

                button.setBackground(Color.RED);
                button.setEnabled(false);
            }

            asientoSeleccionado.clear();

            JOptionPane.showMessageDialog(this, "Compra Exitosa", "Compra Exitosa" + seat, JOptionPane.INFORMATION_MESSAGE);

            dispose();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la informaciÃ³n en el archivo CSV.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}