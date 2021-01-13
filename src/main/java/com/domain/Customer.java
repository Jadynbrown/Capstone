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
	
//	int mobileNumber; 
//	char gender; 
//	Date dob; 
//	char maritalStatus; 
//	int householdSize; 
//	int income; 
//	String employment; 
//	CreditCardApplication creditCardApp; 
	
}
