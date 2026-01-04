package com.controller;

import java.util.Scanner;

import com.service.PersonService;
import com.service.PersonserviceImplmentation;

public class PersonController {
	public static void main(String[] args) {
		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		PersonService ps=new PersonserviceImplmentation();
		
		while(flag) {
			System.out.println("***********************************************");
			System.out.println("1.Add Person with Adhar");
			System.out.println("2.Display Person only using PID");
			System.out.println("3.Display Adhar using PID");
			System.out.println("4.Update Person using PID");
			System.out.println("5.Update Adhar using PID");
			System.out.println("6.Delete Person using PID");
			System.out.println("7.Delete Adhar using PID");
			
			System.out.println("8.Display Person only using AID");
			System.out.println("9.Display Adhar only using AID");
			System.out.println("10.Update Person only using AID");
			System.out.println("11.Update Adhar only using AID");
			System.out.println("12.Delete Person only using AID");
			System.out.println("13.Delete Adhar only using AID");
			System.out.println("14.EXIT");
			System.out.println("***********************************************");
			System.out.println("Enter the choice::");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				ps.addPersonWithadhar();
				break;
			case 2:
				ps.displayPersonOnlyUsingPID();
				break;
			case 3:
				ps.displayAdharOnlyUsingPID();
				break;
			case 4:
				ps.updatePersonOnlyUsingPID();
				break;
			case 5:
				ps.updateAdharOnlyUsingPID();
				break;
			case 6:
				ps.deletePersonOnlyUsingPID();
				break;
			case 7:
				ps.deleteAdharOnlyUsingPID();
				break;
			case 8:
				ps.displayPersonOnlyUsingAID();
				break;
			case 9:
				ps.displayAdharOnlyUsingAID();
				break;
			case 10:
				ps.updatePersonOnlyUsingAID();
				break;
			case 11:
				ps.updateAdharOnlyUsingAID();
				break;
			case 12:
				ps.deletePersonOnlyUsingAID();
				break;
			case 13:
				ps.deleteAdharOnlyUsingAID();
				break;
			case 14:
				flag=false;
				System.out.println("ThankYou Visit Again!!!");
				break;		
			default:
				System.out.println("Invaild Choice");
				
			}
		}

	}
}
