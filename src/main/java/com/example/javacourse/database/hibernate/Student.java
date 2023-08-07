package com.example.javacourse.database.hibernate;




import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Column(name="student-name")
	private String name;
	
	
	@OneToOne
	private Book book;


	public Student(int sid, String name) {
		super();
		this.id = sid;
		this.name = name;
	}


	public Student(String name) {
		super();
		this.name = name;
	}
	

	

}
