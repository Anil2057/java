package com.example.javacourse.database.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		
		Book b1 = new Book("History", "Bikash Chand");
		Book b2 = new Book("Math", "Hari Chand");
		Book b3 = new Book("Economic", "AJ Chand");
		Student s1 = new Student("Anil");
		Student s2 = new Student("Sumita");
		Student s3 = new Student("Supriya");
		b1.setStudent(s1);
		b2.setStudent(s2);
		b3.setStudent(s3);
		
		s1.setBook(b1);
		s2.setBook(b2);
		s3.setBook(b3);
		
		Configuration con = new Configuration()
							.configure()
							.addAnnotatedClass(Book.class)
							.addAnnotatedClass(Student.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(b1);
		session.save(b2);
		session.save(b3);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		tx.commit();
		session.close();
		
		}
	}

