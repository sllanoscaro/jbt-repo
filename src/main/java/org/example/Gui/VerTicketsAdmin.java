package org.example.Gui;

import org.example.Datos.DatosFunciones;
import org.example.Datos.DatosUsuariosYAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VerTicketsAdmin extends JFrame {

    private JTable table1;
    private JPanel panel;
    private JButton volverButton;


    public VerTicketsAdmin(){
        setTitle("Ver tickets");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        panel = new JPanel();


        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Nombre");
        model.addColumn("Pelicula");
        model.addColumn("Butaca");
        model.addColumn("Sala y Horario");

        volverButton = new JButton("Volver");


        DatosFunciones.mostrarTicketsCSV(model);

        table1 = new JTable(model);

        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(table1), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);



        add(panel);

        setVisible(true);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuAdmin menuAdmin = new MenuAdmin();
            }
        });

    }

}
