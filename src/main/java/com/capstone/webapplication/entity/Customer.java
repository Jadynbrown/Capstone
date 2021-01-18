package com.capstone.webapplication.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_Id")
	Integer customer_Id; 
	
	@Column
	Integer mobile_Number;
	@Column
	Character gender; 
	@Column
	Date date_Of_Birth;
	@Column
	Character marital_Status; 
	@Column
	Integer income; 
	@Column
	Integer ssn;
	@Column
	Integer zip_Code;
	@Column
	String state; 
	@Column
	String region; 
	@Column
	Integer user_Id; 
	@Column
	Integer household_size;
	@Column
	String employment;
	
	@Column
	String name; 
	
	@JsonManagedReference
	@OneToOne(targetEntity = CreditCardApplication.class,  fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.PROXY)
	    private CreditCardApplication creditCardApplication;


	@JsonBackReference
	@OneToOne(targetEntity = CreditCard.class, mappedBy = "customer", fetch = FetchType.LAZY)
	
	     private CreditCard creditCard; 
	
	
	
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	public void setMobile_Number(Integer mobile_Number) {
		this.mobile_Number = mobile_Number;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public void setMarital_Status(Character marital_Status) {
		this.marital_Status = marital_Status;
	}
	public void setIncome(Integer income) {
		this.income = income;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	public void setZip_Code(Integer zip_Code) {
		this.zip_Code = zip_Code;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public void setHousehold_size(Integer household_size) {
		this.household_size = household_size;
	}
	public int getMobile_Number() {
		return mobile_Number;
	}
	public void setMobile_Number(int mobile_Number) {
		this.mobile_Number = mobile_Number;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Date getDate_Of_Birth() {
		return date_Of_Birth;
	}
	public void setDate_Of_Birth(Date date_Of_Birth) {
		this.date_Of_Birth = date_Of_Birth;
	}
	public char getMarital_Status() {
		return marital_Status;
	}
	public void setMarital_Status(char marital_Status) {
		this.marital_Status = marital_Status;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getZip_Code() {
		return zip_Code;
	}
	public void setZip_Code(int zip_Code) {
		this.zip_Code = zip_Code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public int getHousehold_size() {
		return household_size;
	}
	public void setHousehold_size(int household_size) {
		this.household_size = household_size;
	}
	public String getEmployment() {
		return employment;
	}
	public void setEmployment(String employment) {
		this.employment = employment;
	}
	public int getCustomer_Id() {
		return customer_Id;
	}
	
	public void setCustomer_Id(Integer customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
	
}
