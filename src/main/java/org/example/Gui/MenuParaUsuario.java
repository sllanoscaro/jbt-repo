package org.example.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuParaUsuario extends JFrame {

    private JPanel panel;
    private JLabel titulo;
    private JButton botonVerFunciones;
    private JButton botonHacerResena;
    private JLabel usuario;
    private JLabel verFuncionesLabel;
    private JLabel hacerResenasLabel;

    public MenuParaUsuario(String nombre) {
        setTitle("Menu Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        usuario.setText("                                 "+nombre);


        panel.setLayout(new GridLayout(4, 2, 10, 10));




        panel.add(titulo);
        panel.add(usuario);
        panel.add(verFuncionesLabel);
        panel.add(hacerResenasLabel);
        panel.add(botonVerFunciones);
        panel.add(botonHacerResena);



        add(panel);
        setVisible(true);


        botonVerFunciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuFuncionesUsuarios menuFuncionesUsuarios = new MenuFuncionesUsuarios(nombre);
            }
        });

        botonHacerResena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionesParaResenas hacerResena = new FuncionesParaResenas(nombre);

            }
        });



    }}
