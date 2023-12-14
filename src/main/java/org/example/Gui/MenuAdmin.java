package org.example.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame {

    private JPanel panel;
    private JButton botonUsuarios;
    private JButton botonPeliculasDisponibles;
    private JButton botonTicketVendidos;
    private JButton botonResenas;
    private JLabel verTicketsVendidosLabel;
    private JLabel verPeliculasDisponiblesLabel;
    private JLabel verResenasLabel;
    private JLabel verRegistroDeUsariosLabel;
    private JLabel titulo;
    private JButton cerrarSesionButton;
    private JButton verFuncionesBoton;
    private JLabel verFuncionesLabel;
    private JLabel vacio;
    private JLabel vacio1;

    public MenuAdmin() {
        setTitle("Menu Admin");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        panel.setLayout(new GridLayout(7, 2, 10, 10));
        panel.add(titulo);
        panel.add(vacio1);
        panel.add(verRegistroDeUsariosLabel);
        panel.add(verPeliculasDisponiblesLabel);
        panel.add(botonUsuarios);
        panel.add(botonPeliculasDisponibles);
        panel.add(verTicketsVendidosLabel);
        panel.add(verResenasLabel);
        panel.add(botonTicketVendidos);
        panel.add(botonResenas);
        panel.add(verFuncionesLabel);
        panel.add(vacio);
        panel.add(verFuncionesBoton);
        panel.add(cerrarSesionButton);

        add(panel);
        setVisible(true);

/**
 * abre la ventana funciones disponibles
 */
        botonPeliculasDisponibles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaFuncionesEditables ventanaFuncionesEditables = new VentanaFuncionesEditables();
            }
        });
        /**
        * abre la ventana verUsuarios
        */
        botonUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VerUsuarios verUsuarios = new VerUsuarios();
            }
        });

        /**
         * abre la ventana ventanaAdminVerResenas
         */
        botonResenas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaAdminVerResenas ventanaAdminVerResenas = new VentanaAdminVerResenas();
            }
        });

        /**
         * abre la ventana verTicketsAdmin
         */
        botonTicketVendidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VerTicketsAdmin verTicketsAdmin = new VerTicketsAdmin();
            }
        });

        /**
         * Vuelve a la ventana login
         */
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
            }
        });
        verFuncionesBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                EditarFunciones editarFunciones = new EditarFunciones();
            }
        });



    }}
