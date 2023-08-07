package com.example.javacourse.database.studentForm;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class EditWindow extends JFrame implements ActionListener {

	JLabel header, title, name, address, dob, contact, gender, course;
	JTextField nameField, addField, contactField, idField;
	JButton submit, edit, delete, ustate;
	JDatePickerImpl datePicker;
	JDatePanelImpl datePanel;
	UtilDateModel dateModel;
	JComboBox cb;
	String gen[] = { "Male", "Female" };
	JCheckBox checkBox1, checkBox2;
	StudentDAO studentDao = new StudentDAO();
	JTabbedPane tabbedPane;
	JPanel fillPanel;
	Myframe sForm;
	ArrayList<Student> students;

	public EditWindow(Student st, Myframe sForm) {
		this.sForm = sForm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Registration Form");
		Container c = getContentPane();
		setBounds(200, 100, 450, 520);

		fillPanel = new JPanel();
		fillPanel.setLayout(null);

		header = new JLabel("Registration Form");
		fillPanel.add(header);

		title = new JLabel("Fill up the form");
		title.setFont(new Font("Serif", Font.BOLD, 20));
		title.setBounds(20, 10, 400, 30);
		fillPanel.add(title);

		idField = new JTextField();
		idField.setText(st.getId() + "");

		name = new JLabel("Name");
		name.setBounds(20, 50, 150, 20);
		fillPanel.add(name);

		nameField = new JTextField(30);
		nameField.setBounds(120, 50, 150, 20);
		nameField.setText(st.getName());
		fillPanel.add(nameField);

		address = new JLabel("Address");
		address.setBounds(20, 100, 150, 20);
		fillPanel.add(address);

		addField = new JTextField(30);
		addField.setBounds(120, 100, 150, 20);
		addField.setText(st.getAddress());
		fillPanel.add(addField);

		contact = new JLabel("Contact");
		contact.setBounds(20, 150, 150, 20);
		fillPanel.add(contact);

		contactField = new JTextField(15);
		contactField.setBounds(120, 150, 150, 20);
		contactField.setText(st.getContact());
		fillPanel.add(contactField);

		gender = new JLabel("Gender");
		gender.setBounds(20, 200, 150, 20);
		fillPanel.add(gender);

		cb = new JComboBox<String>(gen);
		cb.setBounds(120, 200, 150, 20);
		int i = 0;
		for (i = 0; i < gen.length; i++) {
			if (gen[i].equals(st.getGender())) {
				break;
			}
		}
		cb.setSelectedIndex(i);
		fillPanel.add(cb);

		dob = new JLabel("Date of birth");
		dob.setBounds(20, 250, 150, 20);
		fillPanel.add(dob);

		dateModel = new UtilDateModel();
		datePanel = new JDatePanelImpl(dateModel);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(120, 250, 150, 20);
		dateModel.setDate(st.getDob().getYear() + 1900, st.getDob().getMonth(), st.getDob().getDate());
		dateModel.setSelected(true);
		datePicker.setTextEditable(true);
		datePicker.setVisible(true);
		fillPanel.add(datePicker);

		course = new JLabel("Courses");
		course.setBounds(20, 300, 150, 20);
		fillPanel.add(course);

		List<String> courses = Arrays.asList(st.getCourse().split(","));

		checkBox1 = new JCheckBox("Java");
		checkBox1.setBounds(120, 300, 70, 20);
		checkBox1.setSelected(courses.contains("Java"));
		fillPanel.add(checkBox1);

		checkBox2 = new JCheckBox("React");
		checkBox2.setBounds(210, 300, 100, 20);
		checkBox1.setSelected(courses.contains("React"));
		fillPanel.add(checkBox2);

		submit = new JButton("Submit");
		submit.setBounds(130, 380, 100, 20);
		fillPanel.add(submit);
		c.add(fillPanel);
		setLayout(null);
		setVisible(true);

		submit.addActionListener(this);
		setContentPane(c);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Forms Panel");
		if (submit.equals((JButton) e.getSource())) {
			Student st = new Student();
			st.setId(Integer.parseInt(idField.getText()));
			st.setName(nameField.getText());
			st.setAddress(addField.getText());
			if (dateModel.getValue() != null) {
				st.setDob(dateModel.getValue());
			}
			st.setContact(contactField.getText());
			st.setGender((String) cb.getSelectedItem());
			st.setCourse((checkBox1.isSelected() ? "Java" : "") + (checkBox2.isSelected() ? "React" : ""));
			System.out.println(st);
			studentDao.update(st);
			ArrayList<Student> students = studentDao.getAll();
			// this.formsWindow.tablePanel=new ProductTablePanel(formsWindow);
			this.sForm.sTable.model.students = students;
			this.sForm.sTable.model.fireTableDataChanged();
			this.sForm.update(getGraphics());
			this.sForm.invalidate();
			this.sForm.validate();
			this.sForm.repaint();
			this.dispose();

		}
	}
}
