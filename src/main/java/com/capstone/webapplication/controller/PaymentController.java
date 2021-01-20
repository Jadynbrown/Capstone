package com.capstone.webapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.webapplication.dto.IStateCost;
import com.capstone.webapplication.dto.ITypeCost;
import com.capstone.webapplication.entity.CreditCard;
import com.capstone.webapplication.entity.Payment;
import com.capstone.webapplication.service.CreditCardService;
import com.capstone.webapplication.service.PaymentService;




@RestController	
public class PaymentController {
	
	@Autowired
	private PaymentService paymentData;
	@Autowired
	private CreditCardService creditCardService; 
	
	@GetMapping("/creditcards/{creditCardId}/payments")
	public ResponseEntity<List<Payment>> getPayments(@PathVariable Integer creditCardId){
		return ResponseEntity.ok(paymentData.getPayments(creditCardId));
	}
	
	
	
	@GetMapping("/creditcards/{creditCardId}/payments/{paymentId}")
	public Payment getPayment(@PathVariable Integer paymentId)
	{
		return paymentData.getPayment(paymentId);
	}
	
	@PostMapping( "/creditcards/{creditCardId}/payments")
	public Payment addCreditCard(@RequestBody Payment payment, @PathVariable Integer creditCardId)
	{  
		payment.setCreditCard(new CreditCard(creditCardId));
		return paymentData.addPayment(payment);
		
		
	}
	
	
}