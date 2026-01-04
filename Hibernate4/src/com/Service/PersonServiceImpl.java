package com.Service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.entity.Adhar;
import com.entity.Person;

public class PersonServiceImpl implements PersonService{
	Scanner sc=new Scanner(System.in);
	SessionFactory sf=HibernateUtil.getSessionFactory();

	@Override
	public void addPersonWithadhar() {
		// TODO Auto-generated method stub
		Person p=new Person();
		Session s=sf.openSession();
		System.out.println("Enter the PersonName:-");
		p.setPname(sc.next());
		Adhar ad=new Adhar();
		System.out.println("Enter the Adharnumber:-");
		ad.setAdharNumber(sc.next());
		p.setAdhar(ad);
		s.save(p);
		s.beginTransaction().commit();
		System.out.println("Person Inserted");
		
	}

	@Override
	public void displayPersonOnlyUsingPID() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the person Id::");
		int id=sc.nextInt();
		Person person=s.get(Person.class,id);
		if(person!=null) {
			System.out.println("Person ID::"+person.getPid());
			System.out.println("Person Name::"+person.getPname());
		}else {
			System.out.println("Invalid ID");
		}
	}

	@Override
	public void displayAdharOnlyUsingPID() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the person Id::");
		int id=sc.nextInt();
		Person person=s.get(Person.class,id);
		if(person!=null) {
			Adhar adhar=person.getAdhar();
			System.out.println("Adhar ID::"+adhar.getAdharId());
			System.out.println("Adhar Number::"+adhar.getAdharNumber());
		}else {
			System.out.println("Invalid ID");
		}
		
	}

	@Override
	public void updatePersonOnlyUsingPID() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the person Id::");
		int id=sc.nextInt();
		Person person=s.get(Person.class,id);
		if(person!=null) {
			System.out.println("Previous Name::"+person.getPname());
			System.out.println("Enter the new Name::-");
			person.setPname(sc.next());
			s.update(person);
			s.beginTransaction().commit();
			System.out.println("Person Updated");
		}else {
			System.out.println("Invalid ID");
		}
		
	}

	@Override
	public void updateAdharOnlyUsingPID() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the person Id::");
		int id=sc.nextInt();
		Person person=s.get(Person.class,id);
		if(person!=null) {
			Adhar adhar=person.getAdhar();
			System.out.println("Previous Adharnumber::"+adhar.getAdharNumber());
			System.out.println("Enter the new Adharnumber::-");
			adhar.setAdharNumber(sc.next());
			s.update(adhar);
			s.beginTransaction().commit();
			System.out.println("Adhar number Updated");
		}else {
			System.out.println("Invalid ID");
		}
		
		
	}

	@Override
	public void deletePersonOnlyUsingPID() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the person Id::");
		int id=sc.nextInt();
		Person person=s.get(Person.class,id);
		if(person!=null) {
			person.setAdhar(null);
			s.update(person);
			s.delete(person);
			s.beginTransaction().commit();
			System.out.println("Person Deleted");
		}else {
			System.out.println("Invalid ID");
		}
		
		
	}

	@Override
	public void deleteAdharOnlyUsingPID() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the Person Id::");
		int id=sc.nextInt();
		Person p=s.get(Person.class, id);
	
		if(p!=null) {
			Adhar ad=p.getAdhar();
			p.setAdhar(null);
			s.update(p);
			s.delete(ad);
			s.beginTransaction().commit();
			System.out.println("Adhar Deleted");
		}else {
			System.out.println("Invalid ID");
		}
		
		
	}

}
