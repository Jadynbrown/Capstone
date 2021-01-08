package com.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CreditCardRepository;
import com.domain.CreditCard;

@Service
public class CreditCardBO { //not sure this ccbo should be extending creditCard repository  and then adding business logic, or if business logic should be in ccrepo
	@Autowired
	CreditCardRepository creditCardRepo; 
	
	public List<CreditCard> getCreditCards(){
		return creditCardRepo.findAll(); 		
	}
	
}
