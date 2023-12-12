package org.example.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import org.example.Datos.DatosUsuariosYAdmin;
import org.example.Modelo.Admin;
import org.example.Modelo.Usuario;


public class Login extends JFrame {
    private JTextField usuarioText;
    private JTextField claveText;
    private JButton iniciarsesion;
    private JButton crearcuenta;
    private JLabel usuario;
    private JLabel clave;
    private JPanel panel;

    public Login() {
        setTitle("Login");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();


        panel.setLayout(new GridLayout(3, 2, 10, 10));


        panel.add(usuario);
        panel.add(usuarioText);
        panel.add(clave);
        panel.add(claveText);
        panel.add(iniciarsesion);
        panel.add(crearcuenta);

        add(panel);
        setVisible(true);

        Admin admin1 = new Admin();
        DatosUsuariosYAdmin.guardarDatosAdminEnCSV(admin1);

        crearcuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String usuario = usuarioText.getText();
                String clave = claveText.getText();

                if (usuario.isEmpty() || clave.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (DatosUsuariosYAdmin.buscarUsuarioPorNombre(usuario)){
                    JOptionPane.showMessageDialog(null, "Un usuario con ese nombre ya existe, porfavor intente denuevo", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Usuario usuario1 = new Usuario();
                usuario1.setNombre(usuario);
                usuario1.setClave(clave);
                DatosUsuariosYAdmin.guardarDatosEnCSV(usuario1);
                JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente", "Cuenta creada", JOptionPane.ERROR_MESSAGE);
                usuarioText.setText("");
                claveText.setText("");
            }
        });

        iniciarsesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuarioText.getText().isEmpty() || claveText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (DatosUsuariosYAdmin.buscarUsuarioyClave(usuarioText.getText(), claveText.getText())){
                    JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso", "Bienvenido", JOptionPane.WARNING_MESSAGE);

                    if (DatosUsuariosYAdmin.buscarUsuarioOAdmin(usuarioText.getText(), claveText.getText())){
                        JOptionPane.showMessageDialog(null, "Eres admin Crack", "Bienvenido", JOptionPane.WARNING_MESSAGE);
                        dispose();
                        MenuAdmin menuAdmin = new MenuAdmin();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Eres usuario bestia", "Bienvenido", JOptionPane.WARNING_MESSAGE);
                        dispose();
                        MenuParaUsuario menuParaUsuario = new MenuParaUsuario(usuarioText.getText());

                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Fallido", JOptionPane.WARNING_MESSAGE);
                }

                usuarioText.setText("");
                claveText.setText("");
            }
        });
    }
}

