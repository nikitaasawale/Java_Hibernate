package com.controller;

import java.util.Scanner;

import com.service.Studentservice;
import com.service.StudentServiceImpl;

public class Controller {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Studentservice ss=new StudentServiceImpl();
		boolean flag=true;
		while(flag) {
			System.out.println("********************************");
			System.out.println("1.Add Student With Subjects");
			System.out.println("2.Display Student using RollNo");
			System.out.println("3.Display Subject using RollNo");
			System.out.println("4.Update Student using RollNo");
			System.out.println("5.Update Subject using RollNo");
			System.out.println("6.Delete Student Only using RollNo");
			System.out.println("7.Delete Subject Only using RollNo");
			System.out.println("8.EXIT");
			System.out.println("********************************");
			System.out.println("Enter your Choice::");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				ss.addStudentWithSubjects();
				break;
			case 2:
				ss.displayStudentUsingRollNo();
				break;
			case 3:
				ss.displaySubjectUsingRollNo();
				break;
			case 4:
				ss.updateStudentUsingRollNo();
				break;
			case 5:
				ss.updateSubjectUsingRollNo();
				break;
			case 6:
				ss.deleteStudentOnlyUsingRollNo();
				break;
			case 7:
				ss.deleteSubjectOnlyUsingRollNo();
				break;
			case 8:
				flag=false;
				System.out.println("EXIT");
				break;
			default:
				System.out.println("Invalid Choice!!");
			}
		}
	}


}
