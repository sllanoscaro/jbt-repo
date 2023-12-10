package org.example.Gui;

import javax.swing.*;
import java.awt.*;

public class MenuUsuario extends JFrame {

    private JPanel panel;



    public MenuUsuario() {
        setTitle("Menu Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);


        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));


        add(panel);
        setVisible(true);




    }}