package com.capstone.webapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.webapplication.dto.IIncomeCount;
import com.capstone.webapplication.dto.IMaritalStatusCount;
import com.capstone.webapplication.dto.INameReason;
import com.capstone.webapplication.dto.IStateCount;
import com.capstone.webapplication.entity.CreditCard;
import com.capstone.webapplication.repository.CreditCardRepository;



@Service
public class CreditCardService {
	
	@Autowired
	private CreditCardRepository repository;
	
	public CreditCard saveCreditCard(CreditCard creditCard) {
		return repository.save(creditCard); 
				
	}
	
	public List<CreditCard> saveCreditCards(List<CreditCard> creditCards) {
		return repository.saveAll(creditCards); 
				
	}
	
	public  List<CreditCard> getCreditCards() {
		return repository.findAll();
	}
	
	public  CreditCard getCreditCardById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	
	public String deleteCreditCard(Integer id) {
		repository.deleteById(id);
		return "creditCard removed";
	}
	
	public List<String> getCreditCardType() {
		return repository.findByCreditCardType();
	}
	
	public List<CreditCard> getCreditCardExpiring() {
		return repository.findExpiryCreditCard();
	}
	
	public List<IIncomeCount> getCountByIncomeCounts() {
		return repository.findCountByIncomeType();
	}
	public List<IStateCount> getCountByState() {
		return repository.findCountByState();
	}
	public List<IMaritalStatusCount> getCountByMaritalStatus() {
		return repository.findCountByMaritalStatus();
	}
	public List<INameReason> getNameAndReason() {
		return repository.findByNameAndReason();
	}
	
	


}
