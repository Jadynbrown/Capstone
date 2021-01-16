package com.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.domain.CreditCard;
import com.domain.Customer;
import com.bo.CreditCardBO;



@RestController
@RequestMapping("/creditcards")
public class CreditCardController {
	
	@Autowired
	CreditCardBO cbo; 
	
	@GetMapping
	public List<CreditCard> getCreditCards(){
		return cbo.getCreditCards(); 
	}
	
	@GetMapping("/{id}")
	public CreditCard getCreditCardById(@PathVariable(value = "id") int id) {
		return cbo.getCreditCardById(id); 
	}
	//Called with: 	localhost:8080/creditcards?customerid=1 
	//If an improper customer id is entered nothing is added to db. 
	//Throws an error if you already have a creditcard with the entered id
	@PostMapping() 
	public Customer addCreditCard(@RequestBody CreditCard cc, @RequestParam int customerid) {
		return cbo.addCreditCard(cc, customerid);
	}
	
	@PutMapping
	public Customer updateCreditCard(@RequestBody CreditCard cc, @RequestParam int cardid) {
		return cbo.updateCreditCard(cc, cardid);
	}
	
	
//	@DeleteMapping("/{id}") 
//	public void deleteCreditCardById(@PathVariable(value = "id")  int id) {
	@DeleteMapping 
	public Customer deleteCreditCardById(@RequestParam int cardid) {
		return cbo.deleteCreditCardById(cardid);
	}
	

	
}
