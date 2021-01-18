package com.capstone.webapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capstone.webapplication.dto.IStateCost;
import com.capstone.webapplication.dto.ITypeCost;
import com.capstone.webapplication.entity.Payment;



public interface PaymentRepository  extends JpaRepository<Payment, Integer>{
	
	List<Payment> findByCreditCardCreditCardId(Integer creditCardId);
	

	
	
}
