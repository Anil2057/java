package com.example.javacourse.database.studentForm;

import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class StudentTable extends JPanel implements ActionListener {
	Myframe sForm;
	StudentTableModel model;
	ArrayList<JButton> editBtnList = new ArrayList<JButton>();

	public StudentTable(Myframe sForm) {

		this.sForm = sForm;

		model = new StudentTableModel(Myframe.students);

		JTable table = new JTable(model);
		table.getColumn("Action").setCellRenderer(new JTableButtonRenderer());
		table.addMouseListener(new JTableButtonMouseListener(table));
		editBtnList.forEach(btn -> {
			btn.addActionListener(this);
		});
		JScrollPane sPane = new JScrollPane(table);
		add(sPane);

	}

	class StudentTableModel extends AbstractTableModel {
		ArrayList<Student> students = new ArrayList<>();
		String[] cols = { "id", "Name", "Gender", "D.O.B", "Courses", "Action" };

		public StudentTableModel(ArrayList<Student> students) {
			super();
			this.students = students;

			for (int i = 0; i < students.size(); i++) {
				editBtnList.add(new JButton("Edit"));
			}
		}

		@Override
		public int getRowCount() {
			if (students.isEmpty()) {
				return 0;
			}
			return students.size();
		}

		@Override
		public int getColumnCount() {
			if (cols.length == 0 || cols == null) {
				return 0;
			}
			return cols.length;
		}

		@Override
		public Object getValueAt(int row, int col) {
			Object res = null;
			if (col == 0) {
				res = students.get(row).getId();
			} else if (col == 1) {
				res = students.get(row).getName();
			} else if (col == 2) {
				res = students.get(row).getGender();
			} else if (col == 3) {
				res = students.get(row).getDob();
			} else if (col == 4) {
				res = students.get(row).getCourse();
			} else if (col == 5) {
				res = editBtnList.get(row);
			}
			return res;

		}

		@Override
		public Class<?> getColumnClass(int col) {
			if (col == 0) {
				return Integer.class;
			} else if (col == 5) {
				return JButton.class;
			} else
				return String.class;
		}

		@Override
		public String getColumnName(int column) {

			return cols[column];
		}

	};

	class JTableButtonRenderer implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JButton button = (JButton) value;
			return button;
		}
	}

	class JTableButtonMouseListener extends MouseAdapter {
		private final JTable table;

		public JTableButtonMouseListener(JTable table) {
			this.table = table;
		}

		public void mouseClicked(MouseEvent e) {
			int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
			int row = e.getY() / table.getRowHeight(); // get the row of the button

			// *Checking the row or column is valid or not
			if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
				Object value = table.getValueAt(row, column);
				if (value instanceof JButton) {
					// perform a click event
					((JButton) value).doClick();
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton btn = (JButton) e.getSource();
		for (JButton button : editBtnList) {
			if (button.equals(btn)) {
				int index = editBtnList.indexOf(button);
				System.out.println(index + ". Edit button Clicked!");
				Student st = this.model.students.get(index);
				EditWindow editWindow = new EditWindow(st, this.sForm);
				editWindow.setVisible(true);
			}
		}
	}

}
