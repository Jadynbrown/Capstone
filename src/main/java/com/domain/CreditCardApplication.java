package com.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "credit_Card_Application")
public class CreditCardApplication {
	@Id
	@Column(name = "credit_Card_Application_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int creditCardApplicationId; 
	
	@Column(name = "credit_Card_Application_Status")
	char creditCardApplicationStatus; 
	
	@Column(name = "credit_Card_Application_Description")
	String creditCardApplicationDescription; 
	
	@Column(name = "credit_Card_Application_Apply_Date")
	Date applyDate; 
	
	@Column(name = "credit_Card_Application_Approval_Date")
	Date approvalDate;
	
	@Column(name = "credit_Card_Application_Rejection_Date")
	Date rejectionDate;
	
	@Column(name = "requested_Amount")
	double requestedAmount; 
		
	@Column(name = "credit_Score")
	int creditScore; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(
			name = "customer_credit_card_application", 
			joinColumns = {@JoinColumn(name = "credit_Card_Application_Id",  insertable = false, updatable = false)}, 
			inverseJoinColumns = {@JoinColumn(name = "customer_Id",  insertable = false, updatable = false)})
	Customer customer; 

	public CreditCardApplication() {
		super();
	}

	public CreditCardApplication(char credit_Card_Application_Status, String creditCardApplicationDescription, Date applyDate,
			Date approvalDate, Date rejectionDate, double requestedAmount, Users user) {
		super();
		this.creditCardApplicationStatus = credit_Card_Application_Status;
		this.creditCardApplicationDescription = creditCardApplicationDescription;
		this.applyDate = applyDate;
		this.approvalDate = approvalDate;
		this.requestedAmount = requestedAmount;
		this.rejectionDate = rejectionDate; 
	}

	public char getCredit_Card_Application_Status() {
		return creditCardApplicationStatus;
	}

	public void setCreditCardApplicationStatus(char creditCardApplicationStatus) {
		this.creditCardApplicationStatus = creditCardApplicationStatus;
	}

	public String getCreditCardApplicationDescription() {
		return creditCardApplicationDescription;
	}

	public void setCreditCardApplicationDescription(String creditCardApplicationDescription) {
		this.creditCardApplicationDescription = creditCardApplicationDescription;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Date getRejectionDate() {
		return rejectionDate;
	}

	public void setRejectionDate(Date rejectionDate) {
		this.rejectionDate = rejectionDate;
	}

	public double getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}
	public int getCreditCardApplicationId() {
		return creditCardApplicationId;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}


	public char getCreditCardApplicationStatus() {
		return creditCardApplicationStatus;
	}
	
	
}
