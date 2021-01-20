package com.capstone.webapplication.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.webapplication.repository.CreditCardApplicationRepository;

import com.capstone.webapplication.dto.*;
import com.capstone.webapplication.entity.CreditCardApplication;
import com.capstone.webapplication.entity.Customer;


@Service
public class CreditCardApplicationService {
	@Autowired
	CreditCardApplicationRepository ccAppRepo; 
	
	@Autowired
	CustomerService customerService; 
	

	
	public List<IDateCount> countApplicationsByMonth(){
		return ccAppRepo.countApplicationsByMonth();
	}
	
	public List<IDateCount> countApplicationsByYear(){
		return ccAppRepo.countApplicationsByYear();
	}
	
	public List<IDateCount> countApplicationsByDate(String date){
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-DD");
////		Date dateObj = null;
//		try {
////			dateObj = sdf.parse(date);
//			return ccAppRepo.countApplicationsByDate(date);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return null;
		return ccAppRepo.countApplicationsByDate(date);
	}
	public List<IPendingDetail> prospectDetails(){
		return ccAppRepo.prospectDetails();
	}
	public List<IRejectedReason> rejectedDetails(){
		return ccAppRepo.rejectedDetails();
	}
	
	public List<IApprovedReason> approvedDetails(){
		return ccAppRepo.approvedDetails(); 		
	}

	
	public IApproveReponseTime averageTimeToApprove(){
		return ccAppRepo.averageTimeToApprove();
	}
	
	public IRejectReponseTime averageTimeToReject(){
		return ccAppRepo.averageTimeToReject();
	}
	
	public List<IRegionCount> countApprovedByRegion(){
		return ccAppRepo.countApprovedByRegion(); 
	}
	
	public List<IEmploymentCount> countApprovedByEmployment(){
		return ccAppRepo.countApprovedByEmployment(); 
	}
	
	public List<CreditCardApplication> getCreditCardApplications(){
		return ccAppRepo.findAll(); 		
	}
	
	public CreditCardApplication getCreditCardApplicationById(Integer id) {
		return ccAppRepo.findById(id).orElse(null);
	}
	//return ccAppRepo.findById(id).orElseThrow(new ResourceNotFoundException("User not found with id: " + id));custom e
	
	public Customer addCreditCardApplication(CreditCardApplication ccApp, Integer customerId) {
		Customer customer = customerService.findById(customerId);
		if(customer != null) {
			ccApp.setCustomer(customer);
			ccAppRepo.save(ccApp);
			return customer; 
		}
		return null; 
	}
	
	public Customer deleteCreditCardApplicationById(int ccAppId) {
		Customer c = ccAppRepo.findById(ccAppId).get().getCustomer(); 
		ccAppRepo.deleteById(ccAppId);
		return c; 
	}

	//Currently my updates need to take in an entire object! No partial updates.
	public Customer updateCreditCardApplication(CreditCardApplication ccApp, int appId) {
		Optional <CreditCardApplication> existingApp = ccAppRepo.findById(appId);
		if(existingApp.isPresent()) {
			Customer customer = existingApp.get().getCustomer(); 
			ccApp.setId(appId);
			ccApp.setCustomer(customer);
			ccAppRepo.save(ccApp);
			return customer;
		}
		return null;  //throw error, cardapplication not found
	}

	public List<IRegionSale> regionalSales() {
		return ccAppRepo.regionalSales();
	}

	
	
}