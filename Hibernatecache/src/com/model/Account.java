package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="AccountTable")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int accno;
	private String name;
	private String address;
	private long mobileno;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	@Override
	public String toString() {
		return "Account [accno=" + accno + ", name=" + name + ", address=" + address + ", mobileno=" + mobileno + "]";
	}
	

}
