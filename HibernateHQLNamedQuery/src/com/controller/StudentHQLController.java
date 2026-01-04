package com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import com.abc.HibernateUtil;
import com.abc.Student;

public class StudentHQLController {
	public static void fetchAllStudentDetail(SessionFactory sf) {
		Session session=sf.openSession();
		Query<Student> query=session.createQuery("from Student");
		List<Student> studentlist=query.getResultList();
		System.out.println("Student records:");
		for(Student st:studentlist) {
			System.out.println(st);
		}
	}
	public static void fetchAllStudentDetailsbyId(SessionFactory sf) {
		Session session=sf.openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id:");
		int idIn=sc.nextInt();
		
		Query<Object[]> query=session.createQuery("select name,marks from Student where rollno=:id");
		query.setParameter("id", idIn);
		List<Object[]> resultlist=query.getResultList();
		for(Object[] stud:resultlist){
			System.out.println(Arrays.toString(stud));
		}
	}
	public static void fetchminMarks(SessionFactory sf) {
		Session session=sf.openSession();
		
		Query query=session.createQuery("select min(marks) from Student");
		int minmarks=(int) query.getSingleResult();
		System.out.println(minmarks);
		
	}
	public static void fetchAllStudentDetailsbyNamedQuery(SessionFactory sf) {
		Session session=sf.openSession();
		Query<Student> query=session.getNamedQuery("fetchallstudentsByNamedquery");
		List<Student> list=query.getResultList();
		for(Student student:list) {
			System.out.println(student);
		}
		
	}
	public static void updateStudentInfo(SessionFactory sf) {
		Session session=sf.openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Roll number:");
		int IdIn=sc.nextInt();
		System.out.println("Enter marks:");
		int marksIn=sc.nextInt();
		Transaction tx=session.beginTransaction();
		Query query=session.getNamedQuery("updateStudInfo");
		query.setParameter("updatedmarks", marksIn);
		query.setParameter("rollno1", IdIn);
		query.executeUpdate();
		tx.commit();
		System.out.println("Successfully Updated");
	}
	public static void deletestudent(SessionFactory sf) {
		Session session=sf.openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Rollnumber:");
		int rno=sc.nextInt();
		Transaction tx=session.beginTransaction();
		Query query=session.getNamedQuery("deleteStudent");
		query.setParameter("rollnumber", rno);
		query.executeUpdate();
		tx.commit();
		System.out.println("Successfully Deleted!!");
	}
	
	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		//fetchAllStudentDetail(sf);
		//fetchAllStudentDetailsbyId(sf);
		//fetchminMarks(sf);
		//fetchAllStudentDetailsbyNamedQuery(sf);
		//updateStudentInfo(sf);
		deletestudent(sf);
	}

}
