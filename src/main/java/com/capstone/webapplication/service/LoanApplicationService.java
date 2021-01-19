package com.capstone.webapplication.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.webapplication.repository.LoanApplicationRepository;
import com.capstone.webapplication.repository.LoanApplicationRepository;
import com.capstone.webapplication.dto.*;
import com.capstone.webapplication.entity.LoanApplication;
import com.capstone.webapplication.entity.Customer;
import com.capstone.webapplication.entity.LoanApplication;


@Service
public class LoanApplicationService {
	@Autowired
	LoanApplicationRepository loanAppRepo; 
	
	@Autowired
	CustomerService customerService; 
	
	public List<IDateCount> countApplicationsByMonth(){
		return loanAppRepo.countApplicationsByMonth();
	}
	
	public List<IDateCount> countApplicationsByYear(){
		return loanAppRepo.countApplicationsByYear();
	}
	
	public List<IDateCount> countApplicationsByDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-DD");
		Date dateObj = null;
		try {
			dateObj = sdf.parse(date);
			return loanAppRepo.countApplicationsByDate(dateObj);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<IPendingDetail> prospectDetails(){
		return loanAppRepo.prospectDetails();
	}
	public List<IRejectedReason> rejectedDetails(){
		return loanAppRepo.rejectedDetails();
	}
	
	public List<IApprovedReason> approvedDetails(){
		return loanAppRepo.approvedDetails(); 		
	}

	
	public IApproveReponseTime averageTimeToApprove(){
		return loanAppRepo.averageTimeToApprove();
	}
	
	public IRejectReponseTime averageTimeToReject(){
		return loanAppRepo.averageTimeToReject();
	}
	
	public List<IRegionCount> countApprovedByRegion(){
		return loanAppRepo.countApprovedByRegion(); 
	}
	
	public List<IEmploymentCount> countApprovedByEmployment(){
		return loanAppRepo.countApprovedByEmployment(); 
	}
	
	public List<LoanApplication> getLoanApplications(){
		return loanAppRepo.findAll(); 		
	}
	
	public LoanApplication getLoanApplicationById(Integer id) {
		return loanAppRepo.findById(id).orElse(null);
	}
	//return loanAppRepo.findById(id).orElseThrow(new ResourceNotFoundException("User not found with id: " + id));custom e
	
	public Customer addLoanApplication(LoanApplication loanApp, Integer customerId) {
		Customer customer = customerService.findById(customerId);
		if(customer != null) {
			loanApp.setCustomer(customer);
			loanAppRepo.save(loanApp);
			return customer; 
		}
		return null; 
	}
	
	public Customer deleteLoanApplicationById(int loanAppId) {
		Customer c = loanAppRepo.findById(loanAppId).get().getCustomer(); 
		loanAppRepo.deleteById(loanAppId);
		return c; 
	}

	//Currently my updates need to take in an entire object! No partial updates allowed as of now
	public Customer updateLoanApplication(LoanApplication loanApp, int appId) {
		Optional <LoanApplication> existingApp = loanAppRepo.findById(appId);
		if(existingApp.isPresent()) {
			Customer customer = existingApp.get().getCustomer(); 
			loanApp.setId(appId);
			loanApp.setCustomer(customer);
			loanAppRepo.save(loanApp);
			return customer;
		}
		return null;  //throw error, loan application not found
	}


	
	
}