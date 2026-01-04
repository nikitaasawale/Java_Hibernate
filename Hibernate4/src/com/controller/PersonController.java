package com.controller;
import com.Service.PersonService;
import com.Service.PersonServiceImpl;
public class PersonController {
	public static void main(String[] args) {
		PersonService ps=new PersonServiceImpl();
		//ps.addPersonWithadhar();
		//ps.displayPersonOnlyUsingPID();
         //ps.updatePersonOnlyUsingPID();
		//ps.updateAdharOnlyUsingPID();
//		ps.displayPersonOnlyUsingPID();
		//ps.deletePersonOnlyUsingPID();
		ps.deleteAdharOnlyUsingPID();
		//ps.displayAdharOnlyUsingPID();
	}

}
