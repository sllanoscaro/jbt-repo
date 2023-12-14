package org.example.Gui;

import org.example.Datos.DatosFunciones;
import org.example.Modelo.Calculadora;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VerTicketsAdmin extends JFrame {

    private JTable table1;
    private JPanel panel;
    private JButton volverButton;
    private JLabel totalTicketsLabel;
    private JLabel filasJTableLabel;

    public VerTicketsAdmin() {
        setTitle("Ver tickets");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        panel = new JPanel();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Película");
        model.addColumn("Butaca");
        model.addColumn("Sala y Horario");

        volverButton = new JButton("Volver");

        DatosFunciones.mostrarTicketsUsuariosCSV(model);

        table1 = new JTable(model);
        Calculadora calculadora = new Calculadora();

        totalTicketsLabel = new JLabel("Total de Tickets: " + model.getRowCount());
        filasJTableLabel = new JLabel("Dinero total ganado: " + calculadora.calcularPrecioTickets(model,5000) +"$");
        totalTicketsLabel.setSize(26,26);

        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(table1), BorderLayout.CENTER);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2, 1));

        infoPanel.add(totalTicketsLabel);
        infoPanel.add(filasJTableLabel);

        panel.add(infoPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);



        add(panel);

        setVisible(true);

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
    }
}
