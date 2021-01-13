package com.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "credit_card")
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "credit_Card_Id")
	int id; 
	
	@Column(name = "credit_Card_Limit")
	double limit;
	
	@Column(name = "balance")
	double balance; 
	
	@Column(name = "credit_Card_Number")
	long cardNumber; 
	
	@Column(name = "cvv_Number")
	int cvv; 
	
	@Column(name = "expiry_Date")
	Date expirationDate; 
	
//	@OneToOne
//	@JoinColumn(name = "customer_Id")
//	@JsonIgnore
//	Customer customer; 
	
	//should this be a creditCardApplication Object?
	@OneToOne
	@JoinColumn(name = "credit_Card_Application_Id")
	@JsonIgnore
	CreditCardApplication creditCardApplication; 
	
	@OneToMany(mappedBy = "creditCard")
	Set<Transaction> transactions; 
	
	
	public CreditCard() {
		super();
	}

	public CreditCard(double limit, double balance, long cardNumber, int cvv, Date expirationDate, Customer customer,
			CreditCardApplication creditCardApplication) {
		super();
		this.limit = limit;
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
		//this.customer = customer;
		this.creditCardApplication = creditCardApplication;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	//need a set of transactions?

	public CreditCardApplication getCreditCardApplicationId() {
		return creditCardApplication;
	}

	public void setCreditCardApplicationId(CreditCardApplication creditCardApplication) {
		this.creditCardApplication = creditCardApplication;
	}

	public int getId() {
		return id;
	}


	public CreditCardApplication getCreditCardApplication() {
		return creditCardApplication;
	}

	public void setCreditCardApplication(CreditCardApplication creditCardApplication) {
		this.creditCardApplication = creditCardApplication;
	} 
	
	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	


}
