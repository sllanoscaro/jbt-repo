package org.example.Gui;

import org.example.Modelo.Funcion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame {

    private JPanel panel;
    private JButton botonUsuarios;
    private JButton botonFuncionesDisponibles;
    private JButton botonTicketVendidos;
    private JButton botonResenas;
    private JLabel verTicketsVendidosLabel;
    private JLabel verFuncionesDisponiblesLabel;
    private JLabel verResenasLabel;
    private JLabel verRegistroDeUsariosLabel;
    private JLabel adminLabel;
    private JLabel titulo;

    public MenuAdmin() {
        setTitle("Menu Admin");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);


        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.add(titulo);
        panel.add(adminLabel);
        panel.add(verRegistroDeUsariosLabel);
        panel.add(verFuncionesDisponiblesLabel);
        panel.add(botonUsuarios);
        panel.add(botonFuncionesDisponibles);
        panel.add(verTicketsVendidosLabel);
        panel.add(verResenasLabel);
        panel.add(botonTicketVendidos);
        panel.add(botonResenas);


        add(panel);
        setVisible(true);


        botonFuncionesDisponibles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaFuncionesEditables ventanaFuncionesEditables = new VentanaFuncionesEditables();
            }
        });

        botonUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VerUsuarios verUsuarios = new VerUsuarios();
            }
        });
        botonResenas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaAdminVerResenas ventanaAdminVerResenas = new VentanaAdminVerResenas();
            }
        });
        botonTicketVendidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VerTicketsAdmin verTicketsAdmin = new VerTicketsAdmin();
            }
        });



    }}
