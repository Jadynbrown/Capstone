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
}
