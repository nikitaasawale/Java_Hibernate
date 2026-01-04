package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.entity.Student;
import com.entity.Subject;

public class StudentServiceImpl implements StudentService{
	Scanner sc=new Scanner(System.in);
	SessionFactory sf=HibernateUtil.getSessionFactory();

	@Override
	public void addStudentWithSubjects() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		Student st=new Student();
		System.out.println("Enter the Student Name::");
		st.setName(sc.next());
		List<Subject> subjectlist=new ArrayList<Subject>();
		System.out.println("How many Subjects you want to add::");
		int count=sc.nextInt();
		for(int i=1;i<=count;i++) {
			Subject subject=new Subject();
			System.out.println("Enter the Subject name::");
			subject.setSubjectname(sc.next());
			subjectlist.add(subject);
		}
		st.setSubjectlist(subjectlist);
		s.save(st);
		s.beginTransaction().commit();
		System.out.println("Student added Successfully!!");
		
	}

	@Override
	public void displayStudentUsingRollNo() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the Roll No::");
		int rollno=sc.nextInt();
		Student student=s.get(Student.class, rollno);
		if(student!=null) {
			System.out.println("Student Rollno:"+student.getRollNo());
			System.out.println("Student Name::"+student.getName());
		}else {
			System.out.println("Invalid Roll Number");
		}
		
	}

	@Override
	public void displaySubjectUsingRollNo() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the Roll No::");
		int rollno=sc.nextInt();
		Student student=s.get(Student.class, rollno);
		if(student!=null) {
			for(Subject subject:student.getSubjectlist()) {
			System.out.println("Subject Id:"+subject.getSubjectId());
			System.out.println("Subject Name::"+subject.getSubjectname());
			}
		}else {
			System.out.println("Invalid Roll Number");
		}
		
	}

	@Override
	public void updateStudentUsingRollNo() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the Roll No::");
		int rollno=sc.nextInt();
		Student student=s.get(Student.class, rollno);
		if(student!=null) {
			System.out.println("Previous Student name:"+student.getName());
			System.out.println("Enter the new Name:");
			student.setName(sc.next());
			s.update(student);
			s.beginTransaction().commit();
			System.out.println("Student Updated Succesfully!!");
		}else {
			System.out.println("Invalid RollNumber" );
		}
		
		
	}

	@Override
	public void updateSubjectUsingRollNo() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the Roll No::");
		int rollno=sc.nextInt();
		Student student=s.get(Student.class, rollno);
		if(student!=null) {
			for(Subject subject:student.getSubjectlist()) {
				System.out.println("Previous Subject name:"+subject.getSubjectname());
				System.out.println("Enter the new Subject Name:");
				subject.setSubjectname(sc.next());
				s.update(subject);
				s.beginTransaction().commit();
				System.out.println("Subject Updated Succesfully!!");
			}
			
		}else {
			System.out.println("Invalid RollNumber" );
		}
		
	}

	@Override
	public void deleteStudentOnlyUsingRollNo() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the Roll No::");
		int rollno=sc.nextInt();
		Student student=s.get(Student.class, rollno);
		if(student!=null) {
			s.delete(student);
			s.beginTransaction().commit();
			System.out.println("Student Deleted!!");
		}else {
			System.out.println("Invalid RollNumber");
			
		}
		
		
	}

	@Override
	public void deleteSubjectOnlyUsingRollNo() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		System.out.println("Enter the Roll No::");
		int rollno=sc.nextInt();
		Student student=s.get(Student.class, rollno);
		if(student!=null) {
			for(Subject subject:student.getSubjectlist()) {
				student.setSubjectlist(null);
				s.update(subject);
				s.delete(subject);
				s.beginTransaction().commit();
				System.out.println("Subject Deleted!!");
			}
			
		}else {
			System.out.println("Invalid RollNumber");
			
		}
		
	}

}
