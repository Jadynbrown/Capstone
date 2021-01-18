package com.capstone.webapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.webapplication.dto.INameLimit;
import com.capstone.webapplication.dto.INameCcIdClassification;
import com.capstone.webapplication.dto.INameSpendingClassification;
import com.capstone.webapplication.entity.CreditCard;
import com.capstone.webapplication.entity.Customer;
import com.capstone.webapplication.entity.Transaction;
import com.capstone.webapplication.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	

	@GetMapping("/customer")
	@ResponseBody
	public ResponseEntity<List<Customer>> findAllCustomers() {
		System.out.println(customerService.getCustomers());
		return ResponseEntity.ok(customerService.getCustomers());
	}
	
	@GetMapping("/customer/{customer_Id}/creditCard")
	public CreditCard getCreditCard(@PathVariable Integer customer_Id){
		return customerService.getCreditCard(customer_Id);
	}
	
	@GetMapping("/customer/limit")
	public List<INameLimit> getBalanceByCustomer(){
		return customerService.getBalanceByCustomer();
	}
	
	@GetMapping("/customer/payment/classification")
	public List<INameCcIdClassification> getCustomerClassification(){
		return customerService.getCustomerClassificationByPayment();
	}
	
	@GetMapping("/customer/transaction/classification")
	public List<INameSpendingClassification> getCustomerClassificationBySpending(){
		return customerService.getCustomerClassificationBySpending();
	}



	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable(value = "id") Integer id) {
		Customer customer = customerService.getCustomerById(id);
		if (customer == null) {
			return ResponseEntity.notFound().build();

		}
		return ResponseEntity.ok().body(customer);
	}

	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		return customerService.deleteCustomer(id);
	}

}
