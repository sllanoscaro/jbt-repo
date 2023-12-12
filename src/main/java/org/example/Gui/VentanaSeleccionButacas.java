package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaSeleccionButacas extends JFrame {
    private JPanel panelButacas;
    private JButton comprarButacaButton;
    private String numeroSala;
    private DefaultTableModel model;
    private MenuUsuario menuUsuario;
    private List<Integer> butacasDisponibles;

    public VentanaSeleccionButacas(MenuUsuario menuUsuario, DefaultTableModel model, String numeroSala, String horario) {
        this.menuUsuario = menuUsuario;
        this.model = model;
        this.numeroSala = numeroSala;
        this.butacasDisponibles = new ArrayList<>();

        setTitle("Seleccionar Butacas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(menuUsuario);

        panelButacas = new JPanel();
        panelButacas.setLayout(new GridLayout(3, 3));

        cargarButacasDisponibles();

        comprarButacaButton = new JButton("Comprar Butaca");
        comprarButacaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!butacasDisponibles.isEmpty()) {
                    int butacaComprada = butacasDisponibles.remove(0);
                    String butacaCompradaStr = numeroSala + "-" + butacaComprada;
                    menuUsuario.marcarButacaComoComprada(butacaCompradaStr);
                    actualizarEstadoButacas();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(VentanaSeleccionButacas.this,
                            "No hay butacas disponibles para comprar.");
                }
            }
        });

        add(panelButacas, BorderLayout.CENTER);
        add(comprarButacaButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void cargarButacasDisponibles() {
        for (int i = 1; i <= 9; i++) {
            butacasDisponibles.add(i);
            JButton butacaButton = new JButton("Butaca " + i);
            butacaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Puedes agregar lógica para resaltar la butaca seleccionada (opcional)
                }
            });
            panelButacas.add(butacaButton);
        }
    }

    private void actualizarEstadoButacas() {
        int filaSeleccionada = menuUsuario.getDataTable().getSelectedRow();
        model.setValueAt("Butaca Comprada", filaSeleccionada, 6); // 6 es el índice de la columna "Horario"
    }
}
