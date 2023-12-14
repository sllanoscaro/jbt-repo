package org.example.Gui;

import org.example.Datos.DatosFunciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MenuParaUsuario extends JFrame {

    private JPanel panel;
    private JLabel titulo;
    private JButton botonVerFunciones;
    private JButton botonHacerResena;
    private JLabel usuario;
    private JLabel verMisTicketsLabel;
    private JLabel hacerResenasLabel;
    private JButton buttonCerrarSesion;
    private JLabel cerrarSesionLabel;
    private JButton botonVerMisTickets;
    private JLabel verFuncionesLabel;

    public MenuParaUsuario(String nombre) {
        setTitle("Menú Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        usuario.setText("                                 "+nombre);



        panel.setLayout(new GridLayout(5, 2, 10, 10));




        panel.add(titulo);
        panel.add(usuario);
        panel.add(verFuncionesLabel);
        panel.add(verMisTicketsLabel);
        panel.add(botonVerFunciones);
        panel.add(botonVerMisTickets);
        panel.add(hacerResenasLabel);
        panel.add(cerrarSesionLabel);
        panel.add(botonHacerResena);
        panel.add(buttonCerrarSesion);



        add(panel);
        setVisible(true);

/**
 * abre la ventana menuFuncionesUsuario
 */
        botonVerFunciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuFuncionesUsuarios menuFuncionesUsuarios = new MenuFuncionesUsuarios(nombre);
            }
        });

        /**
         * abre la ventana hacerResena
         */
        botonHacerResena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FuncionesParaResenas hacerResena = new FuncionesParaResenas(nombre);

            }
        });

        /**
         * vuelve a la ventana login
         */
        buttonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();

            }
        });
        /**
         * abre la ventana verMisTicketUsuarios
         */
        botonVerMisTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VerMisTicketsUsuario verMisTicketsUsuario = new VerMisTicketsUsuario(nombre);

            }
        });



    }}
