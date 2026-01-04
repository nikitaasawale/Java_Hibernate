package com.Controller;

import java.util.Scanner;

import com.userservice.UserService;
import com.userserviceimpl.ServiceImplementation;

public class UserController {
	public static void main(String[] args) {
		UserService us=new ServiceImplementation();
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("--------------------------------");
			System.out.println("1.Add User");
			System.out.println("2.Get User by UserId");
			System.out.println("3.Update User");
			System.out.println("4.Delete User");
			System.out.println("5.Exit");
			System.out.println("--------------------------------");
			System.out.println("Enter the choice");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				us.addUser();
				break;
			case 2:
				us.getUserByUsingID();
				break;
			case 3:
				us.updateUserUsingId();
				break;
			case 4:
				us.deleteUserUsingId();
				break;
			case 5:
				flag=false;
				System.out.println("Exit");
				break;
			default:
				System.out.println("Inavild Choice!!!!");
			}
		}
	}

}
