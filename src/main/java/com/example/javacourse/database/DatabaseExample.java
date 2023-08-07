package com.example.javacourse.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseExample {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "ansunil2057");
		java.sql.Statement stmt = conn.createStatement();
		
		String insertQuery = "INSERT INTO students (name, address, department) "
				+ "VALUES ('Surya', 'baneshowr', 'law')";
		int rowsAffected = stmt.executeUpdate(insertQuery);
		if(rowsAffected>0) {
			System.out.println("update successful");
		}else {
			System.out.println("update unsuccessful");
		}
		
		ResultSet rs = stmt.executeQuery("select * from students");
		while (rs.next()) {
			System.out.println(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		}
		
		stmt.close();
		conn.close();
	}
}
