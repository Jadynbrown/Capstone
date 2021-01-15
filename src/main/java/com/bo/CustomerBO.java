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


	

}
