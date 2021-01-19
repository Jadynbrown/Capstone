package com.capstone.webapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.webapplication.dto.INameLimit;
import com.capstone.webapplication.dto.IGenderDemographic;
import com.capstone.webapplication.dto.IHouseholdDemographics;
import com.capstone.webapplication.dto.IMaritalDemographic;
import com.capstone.webapplication.dto.INameCcIdClassification;
import com.capstone.webapplication.dto.INameSpendingClassification;
import com.capstone.webapplication.dto.IRegionSale;
import com.capstone.webapplication.dto.ITypeCost;
import com.capstone.webapplication.entity.CreditCard;
import com.capstone.webapplication.entity.Customer;
import com.capstone.webapplication.entity.Transaction;
import com.capstone.webapplication.repository.CustomerRepository;
import java.util.Optional;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer); 
				
	}
	public CreditCard getCreditCard(Integer customer_Id)
	{
		return customerRepository.findByCreditCardCreditCardId(customer_Id);
	}
	public List<Customer> getCustomers1()
	{
		return customerRepository.findAll();
	}
	
	
	public List<INameLimit> getBalanceByCustomer() {
		
		return  customerRepository.findBalanceByCustomer();		
	}
	
public List<INameCcIdClassification> getCustomerClassificationByPayment() {
		
		return  customerRepository.findClassificationByPayment();		
	}

public List<INameSpendingClassification> getCustomerClassificationBySpending() {
	
	return  customerRepository.findClassificationBySpending();		
}

	

public Customer findById(Integer id) {
	Optional<Customer> customer = customerRepository.findById(id);
	if(customer.isPresent()) {
		return customer.get(); 
	}
	return null; //CustomerNotFound: Should throw exception properly
}
	
	public  List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	
	public  Customer getCustomerById(Integer id) {
		return customerRepository.findById(id).orElse(null);
	}

	
	public String deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
		return "customer removed";
	}
	
	public IMaritalDemographic maritalDemographics() {
		return customerRepository.maritalDemographics();
	}

	public List<IHouseholdDemographics> householdSizeDemographics() {
		return customerRepository.householdsizeDemographics();
	}

	public List<IGenderDemographic> genderDemographic() {
		return customerRepository.genderDemographic(); 
	}

	public List<IRegionSale> regionalSales() {
		return customerRepository.regionalSales();
	}
	


}
