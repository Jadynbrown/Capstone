package com.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.domain.CreditCard;
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
	
	@PostMapping
	public void addCreditCard(@RequestBody CreditCard cc) {
		cbo.addCreditCard(cc);
	}
	
	
	@DeleteMapping
	public void deleteCreditCardById(@PathVariable(value = "id")  int ccId) {
		cbo.deleteCreditCardById(ccId);
	}
}
