package com.example.javacourse.database.hibernateOneToMany;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="Book-id")
	private int id;
//	@Column(name="Title")
	private String title;
//	@Column(name="Author")
	private String author;

	@ManyToOne
	 Student student;
//
//	public Book(int id, String title, String author) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.author = author;
//	}

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public Book(Student student) {
		super();
		this.student = student;
	}

}
