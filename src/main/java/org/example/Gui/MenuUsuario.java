package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Datos.DatosFunciones;

public class MenuUsuario extends JFrame {
    private JTable dataTable;
    private JPanel panel;
    private JButton comprarButton;

    public MenuUsuario() {
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
        model.addColumn("Numero de Sala");
        model.addColumn("Horario");

        panel = new JPanel();

        DatosFunciones.mostrarDatosFuncionesCSV(model);

        dataTable = new JTable(model);

        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(dataTable), BorderLayout.CENTER);

        comprarButton = new JButton("Comprar");
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los datos de la fila seleccionada
                    String pelicula = (String) model.getValueAt(selectedRow, 0);
                    String numerosala = (String) model.getValueAt(selectedRow, 5);
                    String horario = (String) model.getValueAt(selectedRow, 6);

                    new VentanaSeleccionButacas(pelicula, numerosala,horario);
                } else {
                    JOptionPane.showMessageDialog(MenuUsuario.this, "Por favor, selecciona una fila para comprar.");
                }
            }
        });

        panel.add(comprarButton, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }


}
