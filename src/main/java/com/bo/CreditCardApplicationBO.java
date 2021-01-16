package com.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.CreditCardApplication;
import com.domain.Customer;
import com.domain.WaitTimeResponse;
import com.dao.CreditCardApplicationRepository;



@Service
public class CreditCardApplicationBO {
	@Autowired
	CreditCardApplicationRepository ccAppRepo; 
	
	@Autowired
	CustomerBO customerBo; 
	
	public List<Object> countApplicationsByMonth(){
		return ccAppRepo.countApplicationsByMonth();
	}
	
	public List<Object> countApplicationsByYear(){
		return ccAppRepo.countApplicationsByYear();
	}
	
	public List<Object> countApplicationsByDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-DD");
		Date dateObj = null;
		try {
			dateObj = sdf.parse(date);
			return ccAppRepo.countApplicationsByDate(dateObj);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<CreditCardApplication> prospectDetails(){
		return ccAppRepo.prospectDetails();
	}
	public List<CreditCardApplication> rejectedDetails(){
		return ccAppRepo.rejectedDetails();
	}
	
	public List<CreditCardApplication> approvedDetails(){
		return ccAppRepo.approvedDetails(); 		
	}

	
	public List<WaitTimeResponse> averageTimeToApprove(){
		return ccAppRepo.averageTimeToApprove();
	}
	
	public List<WaitTimeResponse> averageTimeToReject(){
		return ccAppRepo.averageTimeToReject();
	}
	
	public List<Object> countApprovedByRegion(){
		return ccAppRepo.countApprovedByRegion(); 
	}
	
	public List<Object> countApprovedByEmployment(){
		return ccAppRepo.countApprovedByEmployment(); 
	}
	
	public List<CreditCardApplication> getCreditCardApplications(){
		return ccAppRepo.findAll(); 		
	}
	
	public CreditCardApplication getCreditCardApplicationById(Integer id) {
		return ccAppRepo.findById(id).orElse(null);
	}
	
	public CreditCardApplication addCreditCardApplication(CreditCardApplication ccApp, int customerId) {
		Customer customer = customerBo.findById(customerId);
		if(customer != null) {
			ccApp.setCustomer(customer);
			customer.getCreditCardApplications().add(ccApp);
			customerBo.save(customer);
			return ccApp; 
		}
		return null; 
	}
	
	public void deleteCreditCardApplicationById(int ccAppId) {
		ccAppRepo.deleteById(ccAppId);
	}

	//Currently my updates need to take in an entire object! No partial updates.
	public CreditCardApplication updateCreditCardApplication(CreditCardApplication ccApp) {
		Optional <CreditCardApplication> existingApp = ccAppRepo.findById(ccApp.getCreditCardApplicationId());
		if(existingApp.isPresent()) {
			ccAppRepo.save(existingApp.get());
			return ccApp;
		}
		return null; 
	}

	
	
}
