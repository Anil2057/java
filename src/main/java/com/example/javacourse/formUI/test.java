package com.example.javacourse.formUI;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class test {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setBounds(400, 100, 700, 600);
		
		JMenuItem home = new JMenuItem("Home");
		JMenuItem product = new JMenuItem("Products");
		JMenuItem contact = new JMenuItem("Contact");
		JMenuItem downloads = new JMenuItem("Downloads");
		JMenuItem sell = new JMenuItem("sell");
		JMenuItem purchase = new JMenuItem("Purchase");
		
		JMenu services = new JMenu("Services");
		services.add(sell);
		services.add(purchase);
		
	
		
		JMenuBar menubar = new JMenuBar();
		menubar.setLayout(new FlowLayout(0));
		menubar.add(home);
		menubar.add(product);
		menubar.add(contact);
		menubar.add(downloads);
		menubar.add(services);
		
		frame.setJMenuBar(menubar);
		
		
		
		
		
		
		
		
		frame.setVisible(true);
	}
}
