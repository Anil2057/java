package com.example.javacourse.database.hibernateMTM;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToMany {
	public static void main(String[] args) {
		Book b1 = new Book("History", "Bikash Chand");
		Book b2 = new Book("Math", "Hari Chand");
		Book b3 = new Book("Economic", "AJ Chand");
		Student s1 = new Student("Anil");
		Student s2 = new Student("Sumita");
		Student s3 = new Student("Supriya");
		
		ArrayList <Book> bk = new ArrayList<>();
		bk.add(b1);
		bk.add(b2);
		bk.add(b3);
		
		s1.setBooks(bk);
		s2.setBooks(bk);
		s3.setBooks(bk);
		
		ArrayList<Student> st = new ArrayList<>();
		st.add(s1);
		st.add(s2);
		st.add(s3);
		
		b1.setStudents(st);
		b2.setStudents(st);
		b3.setStudents(st);
		
		

		Configuration con = new Configuration().configure().addAnnotatedClass(Book.class)
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
