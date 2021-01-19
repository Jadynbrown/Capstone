package com.capstone.webapplication.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "credit_card")
public class CreditCard {

	@Id
	@Column(name = "credit_card_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer creditCardId;

	@Column(name = "creditCardNumber")
	private Integer creditCardNumber;
	
	@Column(name = "cvv")
	private Integer CVV;
	
	@Column(name = "issueDate")	
	private Date issueDate;
	
	@Column(name = "creditCardLimit")		
	private Double creditCardLimit;

	@Column(name = "creditCardBalance")
	private Double creditCardBalance;
	
	
	@Column(name = "expirationDate")	
	private Date expirationDate;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "creditCardType")
	private String creditCardType;
	
	@Column(name = "discontinuedReason")
	private String discontinuedReason;
		
	
	@JsonManagedReference
	@OneToOne(targetEntity = Customer.class )
	
	    private Customer customer;
	

	@JsonManagedReference
	@OneToMany( orphanRemoval = true, mappedBy = "creditCard" )
	 public List<Transaction> transactions;
	
	@JsonManagedReference
	@OneToMany( orphanRemoval = true,mappedBy = "creditCard")
	 public List<Payment> payments;
	

	

	
	public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setCreditCard(this);
    }
 
    

	public CreditCard(Integer creditCardId) {
		super();
		this.creditCardId = creditCardId;
	}



	public Integer getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(Integer creditCardId) {
		this.creditCardId = creditCardId;
	}

	public Integer getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(Integer creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Integer getCVV() {
		return CVV;
	}

	public void setDiscontinuedReason(String discontinuedReason) {
		this.discontinuedReason = discontinuedReason;
	}

	public void setCVV(Integer cVV) {
		CVV = cVV;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Double getCreditCardLimit() {
		return creditCardLimit;
	}

	public void setCreditCardLimit(Double creditCardLimit) {
		this.creditCardLimit = creditCardLimit;
	}

	public Double getCreditCardBalance() {
		return creditCardBalance;
	}

	public void setCreditCardBalance(Double creditCardBalance) {
		this.creditCardBalance = creditCardBalance;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getDiscontinuedReason() {
		return discontinuedReason;
	}

	

	public CreditCard() {
		super();
	}

	public CreditCard(Integer creditCardNumber, Integer cVV, Date issueDate, Double creditCardLimit,
			Double creditCardBalance, Date expirationDate, Boolean status, String creditCardType,
			String discontinuedReason) {
		super();
		this.creditCardNumber = creditCardNumber;
		CVV = cVV;
		this.issueDate = issueDate;
		this.creditCardLimit = creditCardLimit;
		this.creditCardBalance = creditCardBalance;
		this.expirationDate = expirationDate;
		this.status = status;
		this.creditCardType = creditCardType;
		this.discontinuedReason = discontinuedReason;
	}	

	

}

