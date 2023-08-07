package com.example.javacourse.database.studentForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;



 class Myframe extends JFrame{
	 
	 JLabel header, title, name, address, dob, contact,gender,course;
	 JTextField nameField,addField, contactField;
	 JButton submit, edit, delete, update;
	 JDatePickerImpl datePicker;
	 JDatePanelImpl datePanel;
	 UtilDateModel dateModel;
	 JComboBox<String> cb;
	 String gen [] = {"Male", "Female"}; 
	 JCheckBox checkBox1, checkBox2;
	 StudentDAO studentDao = new StudentDAO();
	 JTabbedPane tabbedPane;
	 JPanel fillPanel;
	  StudentTable sTable;
	 static ArrayList<Student> students;
	 Myframe sForm;
	 Myframe(){
		 setTitle("Registration Form");
		 Container c = getContentPane();
		 setBounds(200, 100, 450, 520);
		 
		 fillPanel = new JPanel();
		 fillPanel.setLayout(null);
		 
		 header = new JLabel("Registration Form");
		 fillPanel.add(header);
		 
		 title = new JLabel("Fill up the form");
		 title.setFont(new Font("Serif" , Font. BOLD, 20));
		 title.setBounds(20, 10, 400, 30);
		 fillPanel.add(title);
		 
		 name = new JLabel("Name");
		 name.setBounds(20, 50, 150, 20);
		 fillPanel.add(name);
		 
		 nameField = new JTextField(30);
		 nameField.setBounds(120, 50, 150, 20);
		 fillPanel.add(nameField);
		 
		 address = new JLabel("Address");
		 address.setBounds(20, 100, 150, 20);
		 fillPanel.add(address);
		 
		 addField = new JTextField(30);
		 addField.setBounds(120, 100, 150, 20);
		 fillPanel.add(addField);
		 
		 contact = new JLabel("Contact");
		 contact.setBounds(20, 150, 150, 20);
		 fillPanel.add(contact);
		 
		 contactField = new JTextField(15);
		 contactField.setBounds(120, 150, 150, 20);
		 fillPanel.add(contactField);
		 
		 gender = new JLabel("Gender");
		 gender.setBounds(20, 200, 150, 20);
		 fillPanel.add(gender);
		 
		 cb = new JComboBox<String>(gen);
		 cb.setBounds(120, 200, 150, 20);
		 fillPanel.add(cb);
		 
		 dob = new JLabel("Date of birth");
		 dob.setBounds(20, 250, 150, 20);
		 fillPanel.add(dob);
		 
		 dateModel = new UtilDateModel();
		 datePanel = new JDatePanelImpl(dateModel);
		 datePicker = new JDatePickerImpl(datePanel);
		 datePicker.setBounds(120, 250, 150, 20);
		 fillPanel.add(datePicker);
		 
		 course = new JLabel("Courses");
		 course.setBounds(20, 300, 150, 20);
		 fillPanel.add(course);
		 
		 checkBox1 = new JCheckBox("Java");
		 checkBox1.setBounds(120, 300,70,20);
		 fillPanel.add(checkBox1);
		 
		 checkBox2 = new JCheckBox("React");
		 checkBox2.setBounds(210, 300, 100, 20);
		 fillPanel.add(checkBox2);
		 
		 submit = new JButton("Submit");
		 submit.setBounds(130, 380, 100, 20);
		 fillPanel.add(submit);
		 c.add(fillPanel);
		 
		 
		 tabbedPane = new JTabbedPane();
		 tabbedPane.setBounds(20, 10, 400, 450);
		 tabbedPane.add("main",fillPanel);
		 
		 

		 
		 submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Submit clicked");  
				if(submit.equals((JButton)e.getSource())) {
				Student st = new Student();
				st.setName(nameField.getText());
				st.setAddress(addField.getText());
				st.setDob(dateModel.getValue());
				st.setContact(contactField.getText());
				st.setGender((String)cb.getSelectedItem());
				st.setCourse(
						(checkBox1.isSelected()?"Java":"")+
						(checkBox2.isSelected()?"React":"")
						);
				
				System.out.println(st);
				studentDao.save(st);
				
				nameField.setText("");
				addField.setText("");
				contactField.setText("");
				dateModel.setDate(0, 0, 0);
				cb.setSelectedIndex(0);
				checkBox1.setSelected(false);
				checkBox2.setSelected(false);
				sTable.model.students=studentDao.getAll();
				sTable.model.fireTableDataChanged();
				}
				
			}
		});
		 
//		 Table panel
		 students = studentDao.getAll();
		 sTable = new StudentTable(this);
		 
		 tabbedPane.add("details",sTable);
		 
		 c.add(tabbedPane);
		 
		 setLayout(null);
		 setVisible(true);
	 }
	
}



public class StudentForm {
	public static void main(String[] args) {
	
		Myframe frame = new Myframe();
		
	}	

}
