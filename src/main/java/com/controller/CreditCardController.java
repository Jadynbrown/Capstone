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
	
	@PostMapping()
	public CreditCard addCreditCard(@RequestBody CreditCard cc, @RequestParam int customerid) {
		return cbo.addCreditCard(cc, customerid);
	}
	
	@PutMapping
	public CreditCard updateCreditCard(@RequestBody CreditCard cc) {
		return cbo.updateCreditCard(cc);
	}
	
	
	@DeleteMapping("/{id}") 
	public void deleteCreditCardById(@PathVariable(value = "id")  int id) {
		cbo.deleteCreditCardById(id);
	}
	
	
}
