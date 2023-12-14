package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Datos.DatosFunciones;
import org.example.Modelo.Funcion;


public class VentanaFuncionesEditables extends JFrame {
    private JTable dataTable;
    private JPanel panel;
    private JButton editarButton;
    private JButton asignarSalaButton;
    private JButton agregarPeliculaButton;
    private JButton volverButton;


    public VentanaFuncionesEditables() {
        setTitle("Funciones Editables");
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

        panel = new JPanel();

        DatosFunciones.mostrarDatosCSV(model);

        dataTable = new JTable(model);

        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(dataTable), BorderLayout.CENTER);

        // Instantiate the buttons
        editarButton = new JButton("Editar Datos");
        asignarSalaButton = new JButton("Asignar Sala");
        agregarPeliculaButton = new JButton("Agregar Película");
        volverButton = new JButton("Volver");


/**
 * abre la ventana ventanaAsignarSala y le entrega una funcion
 */
        asignarSalaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow != -1) {
                    String pelicula = (String) dataTable.getValueAt(selectedRow, 0);
                    String genero = (String) dataTable.getValueAt(selectedRow, 1);
                    String director = (String) dataTable.getValueAt(selectedRow, 2);
                    String sinopsis = (String) dataTable.getValueAt(selectedRow, 3);
                    String clasificacion = (String) dataTable.getValueAt(selectedRow, 4);
                    Funcion funcion = new Funcion(pelicula,genero,director,sinopsis,clasificacion,"");

                    new VentanaAsignarSala(funcion);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una fila para editar.");
                }
            }
        });

        /**
         * abre la ventana ventanaEdicion con los datos de la fila seleccionada
         */
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow != -1) {
                    String pelicula = (String) dataTable.getValueAt(selectedRow, 0);
                    String genero = (String) dataTable.getValueAt(selectedRow, 1);
                    String director = (String) dataTable.getValueAt(selectedRow, 2);
                    String sinopsis = (String) dataTable.getValueAt(selectedRow, 3);
                    String clasificacion = (String) dataTable.getValueAt(selectedRow, 4);

                    new VentanaEdicion(pelicula, genero, director, sinopsis, clasificacion);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una fila para editar.");
                }

            }
        });

        /**
         * abre la ventana agregarFuncion
         */
        agregarPeliculaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarFuncion agregarFuncion = new AgregarFuncion();
                dispose();

            }
        });

        /**
         * vuelve a la ventana menuAdmin();
         */
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuAdmin menuAdmin = new MenuAdmin();
            }
        });

        // Add both buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(asignarSalaButton);
        buttonPanel.add(editarButton);
        buttonPanel.add(agregarPeliculaButton);
        buttonPanel.add(volverButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }
}
