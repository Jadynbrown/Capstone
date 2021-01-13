package com.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "credit_card_transaction")
public class Transaction {
	
	@Id
	@Column(name = "transaction_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int transactionId; 
	
	@ManyToOne
	@JoinColumn(name = "credit_Card_Id")
	@JsonIgnore
	CreditCard creditCard; 
	
	@Column(name = "transaction_Amount")
	double transactionAmount; 
	
	@Column(name = "transaction_Type")
	String transactionType;
	
	@Column(name = "transaction_Date")
	Date transactionDate;
	
	public Transaction() {
		super();
	}

	public Transaction(int transactionId, CreditCard creditCard, double transactionAmount, String transactionType,
			Date transactionDate) {
		super();
		this.transactionId = transactionId;
		this.creditCard = creditCard;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getTransactionId() {
		return transactionId;
	} 
	
	
}
