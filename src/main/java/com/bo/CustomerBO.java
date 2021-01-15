package com.bo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.CustomerRepository;
import com.domain.CreditCard;
import com.domain.CreditCardApplication;
import com.domain.Customer;

import jdk.jfr.internal.Logger;

@Service
public class CustomerBO {
	@Autowired
	CustomerRepository repo;


	public List<Customer> findAll(){
		return repo.findAll();
	}
	

	public Customer findById(int id) {
		Optional<Customer> customer = repo.findById(id);
		if(customer.isPresent()) {
			return customer.get(); 
		}
		return null; //CustomerNotFound: Should throw exception properly
	}

	public Customer save(Customer customer) {
		return repo.save(customer);
	}
	

	public void deleteById(int custId) {
		repo.deleteById(custId);
	}


	public Customer addCreditCard(int id, CreditCard cc) {
		Optional<Customer> cFromDb = repo.findById(id);
		if(cFromDb.isPresent()) {
			cFromDb.get().getCreditCards().add(cc); //Also add checking that the card isn't already present! 
			save(cFromDb.get());
			return cFromDb.get();
		}
		return null; //CustomerNotFound: Should throw exception properly
	}

	public Customer removeCreditCard(int customerId, int cardId) {
		Optional<Customer> cFromDb = repo.findById(customerId);
		if(cFromDb.isPresent()) {
			Boolean cardFound = cFromDb.get().getCreditCards().removeIf(a -> a.getId() == cardId);
			save(cFromDb.get());
			return cFromDb.get(); 
		}
		return null; //CustomerNotFound: Should throw exception properly
	}


	public CreditCard getCreditCard(int customerId, int cardId) {
		Optional<Customer> cFromDb = repo.findById(customerId);
		if(cFromDb.isPresent()) {
			CreditCard customerCard = cFromDb.get().getCreditCards().stream()
					.filter(a -> a.getId() == cardId)
					.findFirst()
					.get();
			if(customerCard == null) {
				//throw error, they sent wrong card id
			}
			return customerCard;
		}
		return null;
	}


	public Customer addCardApplication(int customerId, CreditCardApplication cardApp) {
		Optional<Customer> cust = repo.findById(customerId); 
		if(cust.isPresent()) {
			cust.get().getCreditApplications().add(cardApp); //NEEDS CHECKING THAT APP ISN'T ALREADY PRESENT
			return cust.get(); 
		}
		return null; 	//THROW ERROR, CUSTOMER ID NOT VALID
	}

}
