package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import org.example.Datos.DatosFunciones;
import org.example.Modelo.Sala;

public class MenuFuncionesUsuarios extends JFrame {
    private JTable dataTable;
    private JPanel panel;
    private JButton comprarButton;
    private JButton volverButton;


    public MenuFuncionesUsuarios(String nombre) {
        setTitle("Menú para ver funciones como usuario");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Película");
        model.addColumn("Género");
        model.addColumn("Director");
        model.addColumn("Sinopsis");
        model.addColumn("Clasificación");
        model.addColumn("Número de Sala");
        model.addColumn("Horario");

        panel = new JPanel();

        DatosFunciones.mostrarDatosFuncionesCSV(model);

        dataTable = new JTable(model);

        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(dataTable), BorderLayout.CENTER);

        comprarButton = new JButton("Comprar");
        volverButton = new JButton("Volver");

        /**
         * abre la ventanaSeleccionButacas con los datos de la fila seleccionada
         */
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow != -1) {
                    String pelicula = (String) model.getValueAt(selectedRow, 0);
                    String numeroSala = (String) model.getValueAt(selectedRow, 5);
                    String horario = (String) model.getValueAt(selectedRow, 6);
                    Sala sala = new Sala(numeroSala,horario);
                    new VentanaSeleccionButacas(sala,nombre,pelicula);

                } else {
                    JOptionPane.showMessageDialog(MenuFuncionesUsuarios.this, "Por favor, selecciona una fila para comprar.");
                }
            }
        });

        /**
         * vuelve a menuParaUsuario
         */
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuParaUsuario menuParaUsuario = new MenuParaUsuario(nombre);
                }

        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(comprarButton);
        buttonPanel.add(volverButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);


        add(panel);

        setVisible(true);
    }


}
