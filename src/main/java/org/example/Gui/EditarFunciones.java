package org.example.Gui;

import org.example.Datos.DatosFunciones;
import org.example.Modelo.Sala;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarFunciones extends JFrame {
    private JTable dataTable;
    private JPanel panel;
    private JButton eliminarButton;
    private JButton volverButton;
    private DefaultTableModel tableModel;

    public EditarFunciones() {
        setTitle("Menu para ver funciones como admin");
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

        eliminarButton = new JButton("Eliminar Todas Las Funciones");
        volverButton = new JButton("Volver");

        /**
         * abre la ventanaSeleccionButacas con los datos de la fila seleccionada
         */
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatosFunciones.borrarContenidoArchivoCSV("src\\main\\resources\\datosFunciones.csv");
                dispose();
                EditarFunciones editarFunciones = new EditarFunciones();
        }});


        /**
         * vuelve a menuParaUsuario
         */
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuAdmin menuAdmin = new MenuAdmin();

            }

        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(eliminarButton);
        buttonPanel.add(volverButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);


        add(panel);

        setVisible(true);
    }

}

