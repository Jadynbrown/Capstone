package com.capstone.webapplication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.webapplication.dto.IStateCost;
import com.capstone.webapplication.dto.ITypeCost;
import com.capstone.webapplication.entity.Payment;
import com.capstone.webapplication.repository.PaymentRepository;



@Service
public class PaymentService {

@Autowired
private PaymentRepository paymentRepo;
	
	public List<Payment> getPayments(Integer creditCardId)
	{
		return paymentRepo.findByCreditCardCreditCardId(creditCardId);
	}

	public Payment getPayment(Integer paymentId) {
		
		 //topics.stream().filter(topic-> topic.getId().equals(id)).findFirst().get();
		Optional<Payment> res=paymentRepo.findById(paymentId);
		
		return res.get();
	}

	public Payment addPayment(Payment payment) {
		paymentRepo.save(payment);
		
		return payment;
	}
	


	
}