package org.example.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.example.Datos.Datos;
import org.example.Modelo.Admin;
import org.example.Modelo.Usuario;

public class MenuUsuario extends JFrame {

    private JPanel panel;
    private JLabel usuario;

    public MenuUsuario(String username) {
        setTitle("Menu Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.add(usuario);
        usuario.setText(username);


        panel.setLayout(new GridLayout(3, 2, 10, 10));
        add(panel);
        setVisible(true);

    }}