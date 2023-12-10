package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Datos.DatosFunciones;

public class VentanaFuncionesEditables extends JFrame {
    private JTable dataTable;
    private JPanel panel;
    private JButton editarButton;
    private JButton asignarSalaButton;

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


        editarButton = new JButton("Editar Datos");


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
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una fila para editar.");
                }
                dispose();
            }
        });

        panel.add(editarButton, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }


}
