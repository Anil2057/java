package com.example.javacourse.formUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RegForm {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Register");
		frame.setBounds(400,100,700,600);
		
//		JPanel panel = new JPanel(new BorderLayout());
		
		JLabel details = new JLabel("Fill out the form");
		details.setHorizontalAlignment(SwingConstants.LEFT);
		details.setVerticalAlignment(SwingConstants.TOP);
		
		
//		frame.add(panel);
		frame.add(details);
		
		frame.setVisible(true);
	}
	
	
	

}
