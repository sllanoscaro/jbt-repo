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
    private JPanel hacerResenasLabel;

    public MenuParaUsuario(String nombre) {
        setTitle("Menu Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        usuario.setText(nombre);
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));



        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel Panel = new JPanel(new GridLayout(1,2,10,10));
        Panel.add(titulo);
        Panel.add(userPanel);




        JPanel Panel1 = new JPanel(new BorderLayout());
        Panel1.add(verFuncionesLabel, BorderLayout.NORTH);
        Panel1.add(botonVerFunciones, BorderLayout.CENTER);

        JPanel Panel2 = new JPanel(new BorderLayout());
        Panel2.add(hacerResenasLabel, BorderLayout.NORTH);
        Panel2.add(botonHacerResena, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        panelBotones.add(Panel1);
        panelBotones.add(Panel2);

        panel.add(Panel,BorderLayout.NORTH);
        panel.add(panelBotones, BorderLayout.CENTER);

        add(panel);
        setVisible(true);


        botonVerFunciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuUsuario menuUsuario = new MenuUsuario(nombre);
            }
        });

        botonHacerResena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionesParaResenas hacerResena = new FuncionesParaResenas(nombre);

            }
        });



    }}
