package org.example.Gui;

import org.example.Datos.DatosFunciones;
import org.example.Datos.DatosUsuariosYAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class VerUsuarios extends JFrame {

    private JTable table1;
    private JPanel panel;

    public VerUsuarios(){
        setTitle("Funciones Editables");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Usuario");
        model.addColumn("Clave");

        DatosUsuariosYAdmin.mostrarDatosCSV(model);

        table1 = new JTable(model);

        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(table1), BorderLayout.CENTER);

        add(panel);

        setVisible(true);

    }
}
