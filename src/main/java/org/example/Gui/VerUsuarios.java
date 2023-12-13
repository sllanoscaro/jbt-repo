package org.example.Gui;

import org.example.Datos.DatosFunciones;
import org.example.Datos.DatosUsuariosYAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VerUsuarios extends JFrame {

    private JTable table1;
    private JPanel panel;
    private JButton volverButton;


    public VerUsuarios(){
        setTitle("Funciones Editables");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Usuario");
        model.addColumn("Clave");

        volverButton = new JButton("Volver");


        DatosUsuariosYAdmin.mostrarDatosCSV(model);

        table1 = new JTable(model);

        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(table1), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);



        add(panel);

        setVisible(true);

        /**
         * vuelve a menuAdmin
         */
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuAdmin menuAdmin = new MenuAdmin();
            }
        });

    }

}
