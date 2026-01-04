package com.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adhar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adharId;
	private String adharNumber;	
	
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
	@Override
	public String toString() {
		return "Adhar [adharId=" + adharId + ", adharNumber=" + adharNumber + "]";
	}
	
	

}
