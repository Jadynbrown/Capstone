package com.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.domain.CCApplication;
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
	
	@Column(name = "customer_Id")
	int customerId; 
	
	//should this be a creditCardApplication Object?
	//@OneToOne
	//@JoinColumn(name = "credit_Card_Application_Id")
	//Transient notation is to allow me to check creditcard uri's while I haven't completed creditcardapplication entity
	@Transient
	@JsonIgnore
	CCApplication creditCardApplication; 
	
	public CreditCard() {
		super();
	}

	public CreditCard(double limit, double balance, long cardNumber, int cvv, Date expirationDate, int customerId,
			CCApplication creditCardApplication) {
		super();
		this.limit = limit;
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
		this.customerId = customerId;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public CCApplication getCreditCardApplicationId() {
		return creditCardApplication;
	}

	public void setCreditCardApplicationId(CCApplication creditCardApplication) {
		this.creditCardApplication = creditCardApplication;
	} 
	
	


}
