package com.controller;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.model.Student;
import com.Config.HibernateUtil;

public class Controller {
	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Scanner sc=new Scanner(System.in);
		Student st1=new Student();
		System.out.println("Enter roll number:");
		st1.setRollno(sc.nextInt());
		System.out.println("Enter name:");
		st1.setStudentName(sc.next());
		System.out.println("Enter marks:");
		st1.setMarks(sc.nextFloat());
		session.saveOrUpdate(st1);
		session.beginTransaction().commit();
		System.out.println("Record get inserted/Updated successfully");
		//Why get method is referred as eager loading
		System.out.println("enter roll number:");
		Student st2=session.get(Student.class, sc.nextInt());
		System.out.println("Get method call::");
		System.out.println(st2.getRollno());
		System.out.println(st2.getStudentName());
		System.out.println(st2.getMarks());
		
		System.out.println("Enter id:");
		Student st3=session.get(Student.class, sc.nextInt());
		System.out.println("Load method call::");
		System.out.println(st3.getRollno());
		System.out.println(st3.getStudentName());
		System.out.println(st3.getMarks());
		
		
		
//		st.setStudentName("Jay");
//		st.setStudentaddress("pimpri");
//		st.setMarks(92.7);
//		st.setAge(20);
//		Serializable id=session.save(st);//it returns id
		//System.out.println(id);
		//session.persist(st);it doesnot return id
		
//		session.save(st);
		//eager loader,actual data,if id does not exist->null
//		Student student =session.get(Student.class, 1);
//		Student student2 =session.get(Student.class, 2);
//		student2.setStudentName("Karan");
		//session.update(student2);
		//session.delete(student2);
		//load gives object not found exception
		//Student stud =session.load(Student.class, 102);
	//	System.out.println(student);
//		session.beginTransaction().commit();
//		System.out.println("Student saved successfully");
	}

}
