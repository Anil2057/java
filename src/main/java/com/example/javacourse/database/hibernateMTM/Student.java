package com.example.javacourse.database.hibernateMTM;




import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;


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
	
	
	@ManyToMany(mappedBy="students")
	private List<Book> books;


	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Student(String name) {
		super();
		this.name = name;
	}
	

	

}
