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
	
	@Column(name = "credit_Card_Application_approval_Date")
	Date approvalDate;
	
	@Column(name = "requested_Amount")
	double requestedAmount; 
	
	@Column(name = "region")
	String region; 
	
	@Column(name = "credit_Score")
	int creditScore; 
	
//	@Column(name = "employment")
//	String employment; 
	
	@Column(name = "income")
	Double income; 
	
//	@OneToOne
//	@JoinColumn(name = "customer_Id")
//	@JsonIgnore
////	@Transient
//	Users user; //int userId;

	public CreditCardApplication() {
		super();
	}

	public CreditCardApplication(char credit_Card_Application_Status, String creditCardApplicationDescription, Date applyDate,
			Date approvalDate, double requestedAmount, Users user) {
		super();
		this.creditCardApplicationStatus = credit_Card_Application_Status;
		this.creditCardApplicationDescription = creditCardApplicationDescription;
		this.applyDate = applyDate;
		this.approvalDate = approvalDate;
		this.requestedAmount = requestedAmount;
		//this.user = user;
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

	public double getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

//	public Users getUser() {
//		return user;
//	}
//
//	public void setCustomerId(Users user) {
//		this.user= user;
//	}

	public int getCreditCardApplicationId() {
		return creditCardApplicationId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

//	public String getEmployment() {
//		return employment;
//	}

//	public void setEmployment(String employment) {
//		this.employment = employment;
//	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public char getCreditCardApplicationStatus() {
		return creditCardApplicationStatus;
	}

//	public void setUser(Users user) {
//		this.user = user;
//	}
	
	
	
}
