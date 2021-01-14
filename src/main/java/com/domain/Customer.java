package com.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "customer_Id")
	int customer_Id; 
	
	@Column
	int mobile_Number;
	@Column
	char gender; 
	@Column
	Date date_Of_Birth;
	@Column
	char marital_Status; 
	@Column
	int house_Hold_Size;
	@Column
	int income; 
	@Column
	int ssn;
	@Column
	int zip_Code;
	@Column
	String state; 
	@Column
	String region; 
	@Column
	int user_Id; 
	@Column
	int household_size;
	@Column
	String employment;
	
	
	@Column
	int loan_Application_Id;	
	@Column
	int credit_Card_Application_Id;
	
	@Column
	int credit_Card_Id;
	@Column
	int loan_Account_Id;
	
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
	public int getHouse_Hold_Size() {
		return house_Hold_Size;
	}
	public void setHouse_Hold_Size(int house_Hold_Size) {
		this.house_Hold_Size = house_Hold_Size;
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
	public int getCredit_Card_Application_Id() {
		return credit_Card_Application_Id;
	}
	public void setCredit_Card_Application_Id(int credit_Card_Application_Id) {
		this.credit_Card_Application_Id = credit_Card_Application_Id;
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
	public int getLoan_Application_Id() {
		return loan_Application_Id;
	}
	public void setLoan_Application_Id(int loan_Application_Id) {
		this.loan_Application_Id = loan_Application_Id;
	}
	public int getCredit_Card_Id() {
		return credit_Card_Id;
	}
	public void setCredit_Card_Id(int credit_Card_Id) {
		this.credit_Card_Id = credit_Card_Id;
	}
	public int getLoan_Account_Id() {
		return loan_Account_Id;
	}
	public void setLoan_Account_Id(int loan_Account_Id) {
		this.loan_Account_Id = loan_Account_Id;
	}
	public int getCustomer_Id() {
		return customer_Id;
	}
	
	
	
}