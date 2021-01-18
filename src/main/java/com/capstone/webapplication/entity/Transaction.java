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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;

	import org.hibernate.annotations.CreationTimestamp;
	import org.hibernate.annotations.UpdateTimestamp;
	import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
	
	@Entity
	@Table(name = "transaction_tbl")
	public class Transaction {

		@Id
		@Column(name = "transactionId")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer transactionId;

		@Column(name = "transactionType")
		private String transactionType;
		
		@Column(name = "cost")
		private Double cost;
		
		@JsonBackReference
		@ManyToOne(optional = false, fetch = FetchType.LAZY)
		private CreditCard creditCard;
		public CreditCard getCreditCard() {
			return creditCard;
		}



		public void setCreditCard(CreditCard creditCard) {
			this.creditCard = creditCard;
		}



		public Transaction() {
			super();
		}
		
		



		public Transaction(String transactionType, Double cost, Date transactionDate, String transactionState) {
			super();
			this.transactionType = transactionType;
			this.cost = cost;
			this.transactionDate = transactionDate;
			this.transactionState = transactionState;
		}



		public Transaction(Integer transactionId, String transactionType, Double cost, Date transactionDate,
				String transactionState) {
			super();
			this.transactionId = transactionId;
			this.transactionType = transactionType;
			this.cost = cost;
			this.transactionDate = transactionDate;
			this.transactionState = transactionState;
		}



		public Integer getTransactionId() {
			return transactionId;
		}



		public void setTransactionId(Integer transactionId) {
			this.transactionId = transactionId;
		}



		public String getTransactionType() {
			return transactionType;
		}



		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}



		public Double getCost() {
			return cost;
		}



		public void setCost(Double cost) {
			this.cost = cost;
		}



		public Date getTransactionDate() {
			return transactionDate;
		}



		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
		}



		public String getTransactionState() {
			return transactionState;
		}



		public void setTransactionState(String transactionState) {
			this.transactionState = transactionState;
		}



		@Column(name = "transactionDate")	
		private Date transactionDate;
		
	

		@Column(name = "transactionState")		
		private String transactionState;
		
	 
		 



		

		

	}



