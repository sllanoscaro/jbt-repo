package Gui;
import logica.CSVReader;
import logica.Funcion;
import logica.Sala;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CineGUI extends JFrame {
    private List<Funcion> funciones;
    private List<Sala> salas;

    public CineGUI(List<Funcion> funciones, List<Sala> salas) {
        this.funciones = funciones;
        this.salas = salas;

        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestión de Cines");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Funcion funcion : funciones) {
            JButton button = new JButton(funcion.getNombre());
            button.addActionListener(new AsignarSalaListener(funcion));
            panel.add(button);
        }

        add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class AsignarSalaListener implements ActionListener {
        private Funcion funcion;

        public AsignarSalaListener(Funcion funcion) {
            this.funcion = funcion;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> salaComboBox = new JComboBox<>();
            for (Sala sala : salas) {
                salaComboBox.addItem(sala.getNumeroSala() + " - " + sala.getHorario());
            }

            int result = JOptionPane.showConfirmDialog(null, salaComboBox, "Seleccionar sala",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                int selectedSalaIndex = salaComboBox.getSelectedIndex();
                Sala selectedSala = salas.get(selectedSalaIndex);
                funcion.agregarSala(selectedSala);

                // Puedes imprimir la información para verificar la asignación
                System.out.println("Se asignó la Sala " + selectedSala.getNumeroSala() +
                        " a la Función " + funcion.getNombre());
                for (Funcion funcion : funciones) {
                    System.out.println("Función: " + funcion.getNombre());
                    for (Sala sala : funcion.getSalas()) {
                        System.out.println("Sala: " + sala.getNumeroSala() + ", Horario: " + sala.getHorario());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Funcion> funciones = CSVReader.leerFuncionesDesdeCSV("src\\main\\resources\\funciones.csv");
        List<Sala> salas = CSVReader.leerSalasDesdeCSV("src\\main\\resources\\salas.csv");

        SwingUtilities.invokeLater(() -> new CineGUI(funciones, salas));

    }
}
