package com.capstone.webapplication.entity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "loan_application")
public class LoanApplication {
	@Id
	@Column(name = "loan_application_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int loanApplicationId; 
	
	@Column(name = "loan_application_status")
	char loanApplicationStatus; 
	
	@Column(name = "loan_pending_description")
	String loanPendingDescription;
	
	@Column(name = "loan_rejected_description")
	String loanRejectedDescription; 
	
	@Column(name = "loan_accepted_description")
	String loanAcceptedReason;
	
	@Column(name = "loan_application_apply_date")
	Date applyDate; 
	
	@Column(name = "loan_application_approval_date")
	Date approvalDate;
	
	@Column(name = "loan_application_rejection_date")
	Date rejectionDate;
	
	@Column(name = "requested_amount")
	double requestedAmount; 
		
	@Column(name = "credit_score")
	int creditScore; 


	@JsonBackReference
	@OneToOne(targetEntity = Customer.class, mappedBy = "loanApplication")
	private Customer customer;

	public LoanApplication() {
		super();
	}

	public LoanApplication(Customer customer, char loan_Application_Status, String loanApplicationDescription, Date applyDate,
			double requestedAmount, Users user) {
		super();
		this.loanApplicationStatus = loan_Application_Status;
		this.loanRejectedDescription = loanApplicationDescription;
		this.applyDate = applyDate;
		this.requestedAmount = requestedAmount;
		this.customer = customer; 
	}

	public char getloanApplicationStatus() {
		return loanApplicationStatus;
	}

	public void setloanapplicationCardApplicationStatus(char loanapplicationStatus) {
		this.loanApplicationStatus = loanapplicationStatus;
	}

	public String getloanapplicationDescription() {
		return loanRejectedDescription;
	}

	public void setloanapplicationDescription(String loanapplicationDescription) {
		this.loanRejectedDescription = loanapplicationDescription;
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
	public int getloanapplicationId() {
		return loanApplicationId;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}


	public char getloanapplicationStatus() {
		return loanApplicationStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setloanapplicationId(int loanapplicationId) {
		this.loanApplicationId = loanapplicationId;
	}

	public void setId(int id) {
		this.loanApplicationId = id; 
		
	}

	public void setCreditCardRejectedDescription(String creditCardRejectedDescription) {
		this.loanRejectedDescription = creditCardRejectedDescription;
	}

	public void setCreditCardAcceptedReason(String creditCardAcceptedReason) {
		this.loanAcceptedReason = creditCardAcceptedReason;
	}

	
	
	
}