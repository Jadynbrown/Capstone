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
@Table(name = "credit_card_application")
public class CreditCardApplication {
	@Id
	@Column(name = "credit_card_application_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int creditCardApplicationId; 
	
	@Column(name = "credit_card_application_status")
	char creditCardApplicationStatus; 
	
	@Column(name = "credit_card_rejected_description")
	String creditCardRejectedDescription; 
	
	@Column(name = "credit_card_pending_description")
	String creditCardPendingDescription;
	
	@Column(name = "credit_card_accepted_description")
	String creditCardAcceptedReason;
	
	@Column(name = "credit_card_application_apply_date")
	Date applyDate; 
	
	@Column(name = "credit_card_application_approval_date")
	Date approvalDate;
	
	@Column(name = "credit_card_application_rejection_date")
	Date rejectionDate;
	
	@Column(name = "requested_amount")
	double requestedAmount; 
		
	@Column(name = "credit_score")
	int creditScore; 


	@JsonBackReference
	@OneToOne(targetEntity = Customer.class, mappedBy = "creditCardApplication", fetch = FetchType.LAZY)
	
	private Customer customer;

	public CreditCardApplication() {
		super();
	}

	public CreditCardApplication(Customer customer, char credit_Card_Application_Status, String creditCardApplicationDescription, Date applyDate,
			Date approvalDate, Date rejectionDate, double requestedAmount, Users user) {
		super();
		this.creditCardApplicationStatus = credit_Card_Application_Status;
		this.creditCardRejectedDescription = creditCardApplicationDescription;
		this.applyDate = applyDate;
		this.approvalDate = approvalDate;
		this.requestedAmount = requestedAmount;
		this.rejectionDate = rejectionDate; 
		this.customer = customer; 
	}

	public char getCredit_Card_Application_Status() {
		return creditCardApplicationStatus;
	}

	public void setCreditCardApplicationStatus(char creditCardApplicationStatus) {
		this.creditCardApplicationStatus = creditCardApplicationStatus;
	}

	public String getCreditCardApplicationDescription() {
		return creditCardRejectedDescription;
	}

	public void setCreditCardApplicationDescription(String creditCardApplicationDescription) {
		this.creditCardRejectedDescription = creditCardApplicationDescription;
	}

	public String getCreditCardPendingDescription() {
		return creditCardPendingDescription;
	}

	public void setCreditCardPendingDescription(String creditCardPendingDescription) {
		this.creditCardPendingDescription = creditCardPendingDescription;
	}

	public String getCreditCardRejectedDescription() {
		return creditCardRejectedDescription;
	}

	public String getCreditCardAcceptedReason() {
		return creditCardAcceptedReason;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCreditCardApplicationId(int creditCardApplicationId) {
		this.creditCardApplicationId = creditCardApplicationId;
	}

	public void setId(int id) {
		this.creditCardApplicationId = id; 
		
	}

	public void setCreditCardRejectedDescription(String creditCardRejectedDescription) {
		this.creditCardRejectedDescription = creditCardRejectedDescription;
	}

	public void setCreditCardAcceptedReason(String creditCardAcceptedReason) {
		this.creditCardAcceptedReason = creditCardAcceptedReason;
	}

	
	
	
}