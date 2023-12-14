package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Datos.DatosFunciones;
import org.example.Modelo.Funcion;


public class FuncionesParaResenas extends JFrame {
    private JTable dataTable;
    private JPanel panel;
    private JButton hacerResenaButton;

    private JButton volverButton;


    public FuncionesParaResenas(String nombre) {
        setTitle("Funciones para hacer reseñas");
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

        hacerResenaButton = new JButton("Hacer Reseña");
        volverButton = new JButton("Volver");


/**
 * obtiene los datos de la fila seleccionada y abre ventana hacerResena con esos datos
 */
        hacerResenaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow != -1) {
                    String pelicula = (String) dataTable.getValueAt(selectedRow, 0);
                    String genero = (String) dataTable.getValueAt(selectedRow, 1);
                    String director = (String) dataTable.getValueAt(selectedRow, 2);
                    String sinopsis = (String) dataTable.getValueAt(selectedRow, 3);
                    String clasificacion = (String) dataTable.getValueAt(selectedRow, 4);

                    new HacerResena(nombre,pelicula, genero, director, sinopsis, clasificacion);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una fila para editar.");
                }
                dispose();
            }
        });

/**
 * vuelve al menu usuario
 */
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuParaUsuario menuParaUsuario = new MenuParaUsuario(nombre);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(hacerResenaButton);
        buttonPanel.add(volverButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }
}
