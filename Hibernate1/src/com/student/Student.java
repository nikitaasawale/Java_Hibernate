package com.student;

public class Student {
	private int rollno;
	private String studentname;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", studentname=" + studentname + "]";
	}
	

}
