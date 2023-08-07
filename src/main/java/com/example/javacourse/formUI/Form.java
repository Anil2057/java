package com.example.javacourse.formUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;

public class Form extends JFrame {
    public Form() {
    	 setTitle("Login Form");
         setSize(300, 150);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel panel = new JPanel();

         JLabel usernameLabel = new JLabel("Username:");
         JTextField usernameField = new JTextField(15);

         JLabel passwordLabel = new JLabel("Password:");
         JPasswordField passwordField = new JPasswordField(15);

         JButton loginButton = new JButton("Login");

         panel.add(usernameLabel);
         panel.add(usernameField);
         panel.add(passwordLabel);
         panel.add(passwordField);
         panel.add(loginButton);

         add(panel);

         setVisible(true);
    }

    public static void main(String[] args) {
        new Form();
    }
}

