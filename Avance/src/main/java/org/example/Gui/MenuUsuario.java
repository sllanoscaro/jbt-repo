package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

import org.example.Datos.DatosFunciones;

public class MenuUsuario extends JFrame {
    private JTable dataTable;
    private JPanel panel;
    private JButton comprarButton;
    private Set<String> butacasCompradas;
    private static final String BUTACAS_COMPRADAS_FILE = "src\\main\\resources\\butacas_compradas.txt";

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

        butacasCompradas = cargarButacasCompradas();

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
                    String pelicula = (String) model.getValueAt(selectedRow, 0);
                    String numeroSala = (String) model.getValueAt(selectedRow, 5);
                    String horario = (String) model.getValueAt(selectedRow, 6);

                    if (!butacasCompradas.contains(numeroSala)) {
                        new VentanaSeleccionButacas(MenuUsuario.this, model, pelicula, numeroSala, horario);
                    } else {
                        JOptionPane.showMessageDialog(MenuUsuario.this,
                                "La butaca ya ha sido comprada para esta función.");
                    }
                } else {
                    JOptionPane.showMessageDialog(MenuUsuario.this, "Por favor, selecciona una fila para comprar.");
                }
            }
        });


        panel.add(comprarButton, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }
    private Set<String> cargarButacasCompradas() {
        Set<String> butacas = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BUTACAS_COMPRADAS_FILE))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                butacas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar butacas compradas desde el archivo.");
        }
        return butacas != null ? butacas : new HashSet<>();
    }
    public void marcarButacaComoComprada(String butacasComprada) {
        butacasCompradas.add(butacasComprada);
        guardarButacasCompradas();
    }

    private void guardarButacasCompradas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BUTACAS_COMPRADAS_FILE))) {
            for (String butaca : butacasCompradas) {
                writer.write(butaca);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al guardar butacas compradas en el archivo.");
        }
    }


}
