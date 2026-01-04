package com.userserviceimpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.User;
import com.userservice.UserService;

public class ServiceImplementation implements UserService{
	Scanner sc=new Scanner(System.in);
	User user=new User();

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
		System.out.println("How many Users you wanto to add:");
		int num=sc.nextInt();
		for(int i=1;i<=num;i++) {
			//System.out.println("Enter the User Id:");
			//user.setUid(sc.nextInt());
			User user=new User();
			System.out.println("Enter the User name:");
			user.setUname(sc.next());
			System.out.println("Enter the User address:");
			user.setUaddress(sc.next());
			System.out.println("Enter the User age:");
			user.setAge(sc.nextInt());
			System.out.println("Enter the User date of birth:");
			user.setDofbirth(sc.next());
			System.out.println("Enter the User Salary:");
			user.setSalary(sc.nextDouble());
			System.out.println("Enter the User Mobile number:");
			user.setMobileno(sc.nextLong());
			s.save(user);
			
			System.out.println(i +" User added Successfully!");
			
		}
		s.beginTransaction().commit();
		
	}

	@Override
	public void getUserByUsingID() {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
		System.out.println("Enter the user id:");
		int userid=sc.nextInt();
		User user=s.get(User.class,userid);
		System.out.println(user);
		s.beginTransaction().commit();
		
	}

	@Override
	public void updateUserUsingId() {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
		System.out.println("Enter the user id:");
		int userid=sc.nextInt();
		User user=s.get(User.class, userid);
		boolean flag=true;
		while(flag) {
			System.out.println("------------------------------------------");
			System.out.println("1.Update User name");
			System.out.println("2.Update User Address");
			System.out.println("3.Update User age");
			System.out.println("4.Update User Dateofbirth");
			System.out.println("5.Update User Salary");
			System.out.println("6.Update User Mobilenumber");
			System.out.println("7.Exit");
			System.out.println("------------------------------------------");
		System.out.println("Enter your choice:");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Enter the new name you want to update:");
			user.setUname(sc.next());
			break;
		case 2:
			System.out.println("Enter the new address you want to update:");
			user.setUaddress(sc.next());
			break;
		case 3:
			System.out.println("Enter the new age you want to update:");
			user.setAge(sc.nextInt());
			break;
		case 4:
			System.out.println("Enter the new DateOfBirth you want to update:");
			user.setDofbirth(sc.next());
			break;
		case 5:
			System.out.println("Enter the new Salary you want to update:");
			user.setSalary(sc.nextDouble());
			break;
		case 6:
			System.out.println("Enter the new Mobile number you want to update:");
			user.setMobileno(sc.nextLong());
			break;
		case 7:
			System.out.println("Exit");
			flag=false;
			break;
		default:
			System.out.println("Invalid choice!!");
			break;
		}
		}
		s.update(user);;
		System.out.println(user);
		s.save(user);
		s.beginTransaction().commit();
		System.out.println("User updated Succesfully!!!");
		
	}

	@Override
	public void deleteUserUsingId() {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
		System.out.println("Enter the user id you want to delete:");
		int userid=sc.nextInt();
		User user=s.get(User.class, userid);
		s.delete(user);
		System.out.println(user);
		s.beginTransaction().commit();
		System.out.println("User deleted Succesfully!!!");
		
		
	}

}
//if(user!=null) {
//	System.out.println("Enter the user id:");
//	int userid=sc.nextInt();
//	if(userid==user.getUid()) {
//		System.out.println(user.getUid());
//		System.out.println(user.getUname());
//		System.out.println(user.getUaddress());
//		System.out.println(user.getAge());
//		System.out.println(user.getDofbirth());
//		System.out.println(user.getSalary());
//		System.out.println(user.getMobileno());
//		
//	}else {
//		System.out.println("User not Found!!");
//	}
//}
