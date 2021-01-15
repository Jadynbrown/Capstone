package com.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.CreditCard;
import com.dao.CreditCardRepository;



@Service
public class CreditCardBO {
	@Autowired
	CreditCardRepository creditCardRepo; 
	
	public List<CreditCard> getCreditCards(){
		return creditCardRepo.findAll(); 		
	}
	
	public CreditCard getCreditCardById(Integer id) {
		Optional<CreditCard> dataBaseCC = creditCardRepo.findById(id);
		if(dataBaseCC.isPresent()){
			return dataBaseCC.get();
		}else
			return null;
	}
	
	public CreditCard addCreditCard(CreditCard cc) {
		return creditCardRepo.save(cc); 
	}
	
	public void deleteCreditCardById(int ccId) {
		creditCardRepo.deleteById(ccId);
	}

	public boolean updateCreditCard(CreditCard cc) {
		Optional<CreditCard> cardFromDb = creditCardRepo.findById(cc.getId());
		if(cardFromDb.isPresent()) {
			cardFromDb.get().setBalance(cc.getBalance()); 
			cardFromDb.get().setLimit(cc.getLimit());
			cardFromDb.get().setStatus(cc.getStatus());
			creditCardRepo.save(cardFromDb.get());
			return true; 
		}else {
			return false; //Handle this Exception 
		}
		
	}
	
	
}
