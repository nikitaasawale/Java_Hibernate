package com.controller;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.abc.Student;
import com.abc.HibernateUtil;

public class NamedNativeQueryController {
	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		//retrieveAllstudentsBynamedNativeQuery(sf);
		//updateStudentbynamednativequery(sf);
		deleteStudentbynamednativequery(sf);
	}
	private static void retrieveAllstudentsBynamedNativeQuery(SessionFactory sf) {
		Session session=sf.openSession();
		Query<Student> query=session.getNamedNativeQuery("retreiveAllAtudentsBynamedNativeQuery");
		List<Student> listofStudents=query.getResultList();
		for(Student st:listofStudents) {
			System.out.println(st);
		}
	}
	public static void updateStudentbynamednativequery(SessionFactory sf) {
		Session session=sf.openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Rollnumber:");
		int Idin=sc.nextInt();
		System.out.println("Enter the marks:");
		int marksIn=sc.nextInt();
		Transaction tx=session.beginTransaction();
		Query query=session.getNamedNativeQuery("updateStudentByNamedNativeQuery");
		query.setParameter("updatedmarks", marksIn);
		query.setParameter("rollno1", Idin);
		query.executeUpdate();
		tx.commit();
		System.out.println("Successfully Updated!!");
	
	}
	public static void deleteStudentbynamednativequery(SessionFactory sf) {
		Session session=sf.openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Rollnumber:");
		int Idin=sc.nextInt();
		Transaction tx=session.beginTransaction();
		Query query=session.getNamedNativeQuery("deleteStudentbyNamedNativeQuery");
		query.setParameter("rollno1", Idin);
		query.executeUpdate();
		tx.commit();
		System.out.println("Successfully Deleted!!");
	}

}
