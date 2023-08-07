package com.example.javacourse.database.hibernate;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="Book-id")
	private int id;
//	@Column(name="Title")
	private String title;
//	@Column(name="Author")
	private String author;
	
	@OneToOne(mappedBy="book")
	private Student student;
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
	
	
	
}
