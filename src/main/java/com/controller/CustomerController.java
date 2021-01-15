package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bo.CustomerBO;
import com.domain.CreditCard;
import com.domain.CreditCardApplication;
import com.domain.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerBO customerBo; 
	
	@GetMapping
	public List<Customer> getCustomers(){
		return customerBo.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable(value = "id") int id) {
		return customerBo.findById(id); 
	}
	//Adds a new customer and returns the customer
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerBo.save(customer);
	}
	//deletes a specific customer and all entities associated with that customer
	@DeleteMapping("/{id}") 
	public void deleteCustomerById(@PathVariable(value = "id")  int custId) {
		customerBo.deleteById(custId);
	}
				//--------------- CREDIT CARD MAPPINGS ------------------ //
	//Adds a new creditCard to customer
	@PostMapping("{customerId}/creditcards")
	public Customer addcreditcard(@RequestBody CreditCard cc, @PathVariable(value = "customerId") int customerId) {
		return customerBo.addCreditCard(customerId, cc);
	}
	//Gets and returns a specific card from a customer
	@GetMapping("{customerId}/creditcards/{cardId}")
	public CreditCard getcreditcard(@PathVariable(value = "customerId") int customerId, 
									 @PathVariable(value = "cardId") int cardId){
		return customerBo.getCreditCard(customerId, cardId);
	}
	//Deletes a specific card from a specific customer
	@DeleteMapping("{customerId}/creditcards/{cardId}")
	public Customer removecreditcard(@PathVariable(value = "customerId") int customerId, 
									 @PathVariable(value = "cardId") int cardId){
		return customerBo.removeCreditCard(customerId, cardId);
	}
	//Need a update card method for a customer
	//@PutMapping("{customerId}/creditcards/{cardId}")  <--- THATS WHERE I'M STOPPING FOR CC's
	
	
			//--------------- CREDIT CARD APPLICATION MAPPINGS ------------------ //
	@PostMapping("{customerId}/cardapplications")
	public Customer addCardApplication(@RequestBody CreditCardApplication cardApp, 
			@PathVariable (value = "customerId") int customerId) {
		return customerBo.addCardApplication(customerId, cardApp);
	}
	//CreditCard applications needs the same mappings as there are for creditcards
	
	// begin work on creditcard application entities. crud operations -> need approve ccApp with cascade
	
	//Remember that entites can  be created alone, 
	//and THEN if you edit the relationship table in sql, the entities are updated! 
	
	
				//--------------- LOAN MAPPINGS ------------------ //
	
	
	
		//--------------- LOAN APPLICATION MAPPINGS ------------------ //
	
	
	
	
}
