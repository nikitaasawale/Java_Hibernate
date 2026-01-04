package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Adhar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adharId;
	private String adharNumber;	
	@OneToOne(cascade = CascadeType.ALL)
	private Person person;
	public int getAdharId() {
		return adharId;
	}
	public void setAdharId(int adharId) {
		this.adharId = adharId;
	}
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Adhar [adharId=" + adharId + ", adharNumber=" + adharNumber + ", person=" + person + "]";
	}
	
	

}
