package com.abc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="Studentdetails")
//HQL
@NamedQueries({
@NamedQuery(name="fetchallstudentsByNamedquery",query="from Student"),
@NamedQuery(name="updateStudInfo",query="update Student set marks=:updatedmarks where rollno=:rollno1"),
@NamedQuery(name="deleteStudent",query="delete from Student where rollno=:rollnumber")
})
//SQL
@NamedNativeQueries({
@NamedNativeQuery(name="retreiveAllAtudentsBynamedNativeQuery",query="select * from studentdetails",resultClass=Student.class),
@NamedNativeQuery(name="updateStudentByNamedNativeQuery",query="update studentdetails set Studentmarks=:updatedmarks where Studentrollno=:rollno1"),
@NamedNativeQuery(name="deleteStudentbyNamedNativeQuery",query="delete from studentdetails where Studentrollno=:rollno1 ",resultClass = Student.class)
})
public class Student {
	@Id
	@Column(name="Studentrollno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rollno;
	@Column(name="StudentName")
	private String name;
	@Column(name="Studentmarks",nullable=false)
	private int marks;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
	


}
