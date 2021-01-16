package com.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
	
	@Column(name = "status")
	String status;
	
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)//Unsure if cascade = CascadeType.ALL here, works w/o  it
//	@JoinTable(
//			name = "customer_credit_card",
//			joinColumns = {@JoinColumn(name = "credit_card_id", insertable = false, updatable = false)}, 
//			inverseJoinColumns = {@JoinColumn (name = "customer_id", insertable = false, updatable = false)})
	//Customer customer;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_Id")
	Customer customer; 
	

	
	public CreditCard() {
		super();
	}

	public CreditCard(double limit, double balance, long cardNumber, int cvv, Date expirationDate, String status) {
		this.limit = limit;
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
		//this.customer = customer;
		this.status = status;
	}
//	public CreditCard(Customer customer, double limit, double balance, long cardNumber, int cvv, Date expirationDate, String status) {
//		this.limit = limit;
//		this.balance = balance;
//		this.cardNumber = cardNumber;
//		this.cvv = cvv;
//		this.expirationDate = expirationDate;
//		//this.customer = customer;
//		this.status = status;
//	}

	public double getLimit() {
		return limit;
	}

	public void setId(int id) {
		this.id = id;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


//	public CreditCardApplication getCreditCardApplication() {
//		return creditCardApplication;
//	}
//
//	public void setCreditCardApplication(CreditCardApplication creditCardApplication) {
//		this.creditCardApplication = creditCardApplication;
//	} 
//	
//	public Set<Transaction> getTransactions() {
//		return transactions;
//	}
//
//	public void setTransactions(Set<Transaction> transactions) {
//		this.transactions = transactions;
//	}

	


}
