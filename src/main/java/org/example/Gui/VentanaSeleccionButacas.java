package org.example.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaSeleccionButacas extends JFrame {
    private MenuUsuario menuUsuario;
    private String pelicula;
    private String numeroSala;
    private String horario;
    private JComboBox<String> butacasComboBox;
    private String butacaSeleccionada;


    public VentanaSeleccionButacas(MenuUsuario menuUsuario, DefaultTableModel model, String pelicula, String numeroSala, String horario) {
        this.menuUsuario = menuUsuario;
        this.pelicula = pelicula;
        this.numeroSala = numeroSala;
        this.horario = horario;

        setTitle("Seleccionar Butacas");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel peliculaLabel = new JLabel("Película:");
        JLabel salaLabel = new JLabel("Número de Sala:");
        JLabel horarioLabel = new JLabel("Horario:");
        JLabel butacasLabel = new JLabel("Seleccionar Butaca:");

        JTextField peliculaTextField = new JTextField(pelicula);
        JTextField salaTextField = new JTextField(numeroSala);
        JTextField horarioTextField = new JTextField(horario);

        butacasComboBox = new JComboBox<>();
        // Cambia esta llamada para obtener las butacas disponibles desde tu lógica específica
        llenarButacasDisponibles(model);

        JButton comprarButacaButton = new JButton("Comprar Butaca");

        comprarButacaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                butacaSeleccionada = (String) butacasComboBox.getSelectedItem();
                // Realiza la lógica para procesar la compra de la butaca
                JOptionPane.showMessageDialog(VentanaSeleccionButacas.this,
                        "Compra realizada:\nPelícula: " + pelicula + "\nNúmero de Sala: " + numeroSala +
                                "\nHorario: " + horario + "\nButaca: " + butacaSeleccionada);
                // Cierra la ventana
                dispose();
            }
        });

        panel.add(peliculaLabel);
        panel.add(peliculaTextField);
        panel.add(salaLabel);
        panel.add(salaTextField);
        panel.add(horarioLabel);
        panel.add(horarioTextField);
        panel.add(butacasLabel);
        panel.add(butacasComboBox);
        panel.add(comprarButacaButton);

        add(panel);

        setVisible(true);
    }

    // Cambia esta lógica según tu implementación real para cargar butacas disponibles
    private void llenarButacasDisponibles(DefaultTableModel model) {
        // Ejemplo de butacas de prueba
        butacasComboBox.addItem("A1");
        butacasComboBox.addItem("A2");
        butacasComboBox.addItem("B1");
        butacasComboBox.addItem("B2");

        // Elimina la butaca comprada de las disponibles
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Object salaEnTablaObject = model.getValueAt(i, 5);
            if (salaEnTablaObject != null) {
                String salaEnTabla = salaEnTablaObject.toString();
                if (numeroSala.equals(salaEnTabla)) {
                    butacasComboBox.removeItem(salaEnTabla);
                    break;  // Puedes remover este break si hay más de una fila con la misma sala
                }
            }
        }}
    public String getButacaSeleccionada() {
        return butacaSeleccionada;
    }
}
