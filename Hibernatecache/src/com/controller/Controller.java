package com.controller;

import java.util.Scanner;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.Account;

public class Controller {
	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Scanner sc=new Scanner(System.in);
		//Account ac=new Account();
//		ac.setName("Karan");
//		ac.setAddress("Mumbai");
//		ac.setMobileno(976356936277l);
//		Account ac2=new Account();
//		ac2.setName("Raj");
//		ac2.setAddress("Pune");
//		ac2.setMobileno(875656936277l);
//		Account ac3=new Account();
//		ac3.setName("Ravi");
//		ac3.setAddress("Nashik");
//		ac3.setMobileno(886356936277l);
//		session.save(ac);
//		session.save(ac2);
//		session.save(ac3);
		Account ac1=session.get(Account.class, 3);
		System.out.println(ac1);
		Account ac2=session.get(Account.class, 4);
		System.out.println(ac2);
		//session.evict(ac1);
		session.clear();
		Cache ch=sf.getCache();
		ch.evictAll();
		Account ac3=session.get(Account.class, 3);
		System.out.println(ac3);
		Account ac4=session.get(Account.class, 4);
		System.out.println(ac4);
//		Session session2=sf.openSession();
//		Account ac2=session2.get(Account.class, 3);
//		System.out.println(ac2);
//		
		session.beginTransaction().commit();
		//System.out.println("Account created Succesfully!!!");
	}

}
