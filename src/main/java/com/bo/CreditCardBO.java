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
	
	public Customer addCreditCard(CreditCard cc, int customerId) {
		Customer c = customerBo.findById(customerId);
		if(c != null) {
			cc.setCustomer(c);
			creditCardRepo.save(cc);
			return c;
		}
		return null; //Customer not found should be thrown
	}
	
	public Customer deleteCreditCardById(int ccId) {
		Customer c = creditCardRepo.findById(ccId).get().getCustomer();
		creditCardRepo.deleteById(ccId);
		return c;
	}
	
	//Currently my updates need to take in an entire object! No partial updates.
	public Customer updateCreditCard(CreditCard cc, int cardId) {
		Optional<CreditCard> cardFromDb = creditCardRepo.findById(cardId);
		if(cardFromDb.isPresent()) {
			Customer customer = cardFromDb.get().getCustomer();
			cc.setCustomer(customer);
			cc.setId(cardId);
			creditCardRepo.save(cc);
			return customer; 
		}else {
			return null; //Handle this Exception, invalid card id 
		}
	}
	
	
}
