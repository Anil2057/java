package com.example.javacourse.database.hibernateOneToMany;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToMany {
	public static void main(String[] args) {
		Book b1 = new Book("History", "Bikash Chand");
		Book b2 = new Book("Math", "Hari Chand");
		Book b3 = new Book("Economic", "AJ Chand");
		Student s1 = new Student("Anil");

		b1.setStudent(s1);
		b2.setStudent(s1);
		b3.setStudent(s1);

		ArrayList<Book> books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
		books.add(b3);

		s1.setBooks(books);

		Configuration con = new Configuration().addAnnotatedClass(Book.class).addAnnotatedClass(Student.class)
				.configure();
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(b1);
		session.save(b2);
		session.save(b3);
		session.save(s1);

		tx.commit();
		session.close();
	}
}
