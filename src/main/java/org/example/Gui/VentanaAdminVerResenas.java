package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Datos.DatosFunciones;
import org.example.Modelo.Funcion;


public class VentanaAdminVerResenas extends JFrame {
    private JTable dataTable;
    private JPanel panel;
    private JButton hacerResenaButton;

    private JButton volverButton;


    public VentanaAdminVerResenas() {
        setTitle("Ver reseñas como admin");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        DefaultTableModel model = new DefaultTableModel();


        model.addColumn("Nombre Usuario");
        model.addColumn("Película");
        model.addColumn("Género");
        model.addColumn("Director");
        model.addColumn("Sinopsis");
        model.addColumn("Clasificación");
        model.addColumn("");
        model.addColumn("");
        model.addColumn("Reseña");


        panel = new JPanel();

        DatosFunciones.mostrarResenasCSV(model);

        dataTable = new JTable(model);

        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(dataTable), BorderLayout.CENTER);

        // Instantiate the buttons
        hacerResenaButton = new JButton("Hacer Reseña");
        volverButton = new JButton("Volver");



/**
 * vuelve a MenuAdmin
 */
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuAdmin menuAdmin = new MenuAdmin();
            }
        });

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(volverButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }
}
