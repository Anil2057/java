package com.example.javacourse.database.studentForm;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
	private Configuration con;
	private SessionFactory sf;
	private Session session;
	private Transaction tx;

	public void config() {
		con = new Configuration().configure().addAnnotatedClass(Student.class);
		sf = con.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
	}

	public void save(Student st) {
		config();
		if (tx.getStatus() == null) {
			tx = session.beginTransaction();
		}
		session.save(st);
		tx.commit();
		session.close();
		sf.close();
	};
	

public ArrayList<Student> getAll() {
	config();
	ArrayList<Student> students =(ArrayList<Student>) session.createQuery("SELECT a FROM Student a", Student.class).getResultList();
	session.close();
	sf.close();
	return students;
}
public String update(Student pd) {
	config();
	if(tx.getStatus()==null) {
		tx=session.beginTransaction();
	}
	session.update(pd);
	tx.commit();
	session.close();
	sf.close();
	return "Done";

}
}
