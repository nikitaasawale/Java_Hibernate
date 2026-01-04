package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.entity.Employee;
import com.entity.HibernateUtil;


public class HomeController {
	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s1=sf.openSession();
		Employee emp=new Employee();
		emp.setEid(101);
		emp.setEname("Ram");
		emp.setEaddress("Pimpri");
		s1.save(emp);
		s1.beginTransaction().commit();
		System.out.println("emp saved");
	}
	
}
