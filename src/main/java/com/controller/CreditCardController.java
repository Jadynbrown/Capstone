package com.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bo.CreditCardBO;
import com.dao.CreditCardRepository;
import com.domain.CreditCard;


@RestController
@RequestMapping("/creditcards")
public class CreditCardController {
	
	@Autowired
	CreditCardBO cbo; 
	//CreditCardRepository cr; 
	
	@GetMapping
	public List<CreditCard> getCreditCards(){
		return cbo.getCreditCards(); 
		//return cr.findAll(); 
	}
}
