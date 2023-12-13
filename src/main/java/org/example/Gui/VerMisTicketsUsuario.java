package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Datos.DatosFunciones;


public class VerMisTicketsUsuario extends JFrame {

    private JTable table1;
    private JPanel panel;
    private JButton volverButton;

    public VerMisTicketsUsuario(String nombre) {
        setTitle("Mis Tickets");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Pelicula");
        model.addColumn("Butaca");
        model.addColumn("Sala y Horario");

        volverButton = new JButton("Volver");

        DatosFunciones.mostrarTicketsUsuariosCSV(DatosFunciones.filtrarFilasPorNombre(nombre,model));

        table1 = new JTable(DatosFunciones.filtrarFilasPorNombre(nombre,model));
        panel = new JPanel();



        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(table1), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
/**
 * vuelve a MenuParaUsuario
 */
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuParaUsuario menuParaUsuario = new MenuParaUsuario(nombre);
            }
        });
    }




}
