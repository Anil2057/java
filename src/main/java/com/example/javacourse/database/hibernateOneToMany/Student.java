package com.example.javacourse.database.hibernateOneToMany;

import java.util.ArrayList;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.*;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@Column(name="student-name")
	private String name;

	@OneToMany(mappedBy="student")
	private List<Book> books;

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
