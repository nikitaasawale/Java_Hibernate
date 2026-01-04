package com.abc;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abc.HibernateUtil;
import com.abc.Student;

public class HomeController {
	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Scanner sc=new Scanner(System.in);
		Session s=sf.openSession();
		System.out.println("How many users you want to add:");
		int num=sc.nextInt();
		for(int i=1;i<=num;i++) {
			Student std=new Student();
			System.out.println("Enter students name:");
			std.setName(sc.next());
			System.out.println("Enter Students marks:");
			std.setMarks(sc.nextInt());
			s.save(std);
			System.out.println("Student added Succesfully!!");
			
			
		}
		s.beginTransaction().commit();
	}
}
