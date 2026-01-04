package com.criteriabuilder;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

import com.abc.HibernateUtil;
import com.abc.Student;

import net.bytebuddy.matcher.EqualityMatcher;

public class CriteriaBuilderDemo {
	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		//getAllstudentdetailsbyCriteriaBuilder(sf);
		//updateStudentbyCriteriaBuilder(sf);
		deleteStudentByCriteriaBuilder(sf);
	}
	private static void getAllstudentdetailsbyCriteriaBuilder(SessionFactory sf) {
		Session session=sf.openSession();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery=builder.createQuery(Student.class);
		Root<Student> root=criteriaQuery.from(Student.class);
		criteriaQuery.select(root);//select * from student
		Query<Student> query=session.createQuery(criteriaQuery);
		List<Student> list=query.getResultList();
		System.out.println("Student details by Criteria builder:");
		for(Student student:list) {
			System.out.println(student);
		}
		
				
	}
	public static void updateStudentbyCriteriaBuilder(SessionFactory sf) {
		Session session=sf.openSession();
		Scanner sc=new Scanner(System.in);
		Transaction tx=session.beginTransaction();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaUpdate<Student> criteriaupdate=builder.createCriteriaUpdate(Student.class);
		Root<Student> root=criteriaupdate.from(Student.class);
		System.out.println("Enter roll number:");
		int rollnum=sc.nextInt();
		System.out.println("Enter the marks:");
		int updatedmarks=sc.nextInt();
		criteriaupdate.set("marks", updatedmarks);
		criteriaupdate.where(builder.equal(root.get("rollno"),rollnum));
		Query query=session.createQuery(criteriaupdate);
		query.executeUpdate();
		tx.commit();
		System.out.println("Student Updated Successfully!!");
		
		
	}
	public static void deleteStudentByCriteriaBuilder(SessionFactory sf) {
		Session session=sf.openSession();
		Scanner sc=new Scanner(System.in);
		Transaction tx=session.beginTransaction();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaDelete<Student> criteriadelete=builder.createCriteriaDelete(Student.class);
		Root<Student> root=criteriadelete.from(Student.class);
		System.out.println("Enter roll number:");
		int rollnum=sc.nextInt();
		criteriadelete.where(builder.equal(root.get("rollno"), rollnum));
		Query query=session.createQuery(criteriadelete);
		query.executeUpdate();
		tx.commit();
		System.out.println("Student Deleted Successfully!!");
	
		
	}

}
