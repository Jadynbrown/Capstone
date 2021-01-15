package com.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.CreditCard;
import com.domain.CreditCardApplication;
import com.domain.Customer;
import com.dao.CreditCardRepository;



@Service
public class CreditCardBO {
	@Autowired
	CreditCardRepository creditCardRepo; 
	@Autowired
	CustomerBO customerBo;
	
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
	
	public CreditCard addCreditCard(CreditCard cc, int customerId) {
		Customer c = customerBo.findById(customerId);
		if(c != null) {
			cc.setCustomer(c);
			c.getCreditCards().add(cc);
			customerBo.save(c);
			return cc;
		}
		return null; //Customer not found should be thrown
	}
	
	public void deleteCreditCardById(int ccId) {
		creditCardRepo.deleteById(ccId);
	}

	public CreditCard updateCreditCard(CreditCard cc) {
		Optional<CreditCard> cardFromDb = creditCardRepo.findById(cc.getId());
		if(cardFromDb.isPresent()) {
			creditCardRepo.save(cc);
			
			return cc; 
		}else {
			return null; //Handle this Exception 
		}
	}
	
	
}
