package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.student.Student;



public class Controller {
	public static void main(String[] args) {
		Configuration config= new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf=config.buildSessionFactory();
		Session s=sf.openSession();
		Student st=new Student();
		st.setRollno(1);
		st.setStudentname("Raj");
		s.save(st);
		s.beginTransaction().commit();
		System.out.println("Student added");
	}

}
