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
import com.dto.IApprovedReason;
import com.dto.IApproveReponseTime;
import com.dto.IDateCount;
import com.dto.IEmploymentCount;
import com.dto.IGenderDemographic;
import com.dto.IHouseholdDemographics;
import com.dto.IMaritalDemographic;
import com.dto.IPendingDetail;
import com.dto.IRegionCount;
import com.dto.IRegionSale;
import com.dto.IRejectReponseTime;
import com.dto.IRejectedReason;
import com.dao.CreditCardApplicationRepository;



@Service
public class CreditCardApplicationBO {
	@Autowired
	CreditCardApplicationRepository ccAppRepo; 
	
	@Autowired
	CustomerBO customerBo; 
	
	public List<IDateCount> countApplicationsByMonth(){
		return ccAppRepo.countApplicationsByMonth();
	}
	
	public List<IDateCount> countApplicationsByYear(){
		return ccAppRepo.countApplicationsByYear();
	}
	
	public List<IDateCount> countApplicationsByDate(String date){
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
	
	public Customer addCreditCardApplication(CreditCardApplication ccApp, int customerId) {
		Customer customer = customerBo.findById(customerId);
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

	public IMaritalDemographic maritalDemographics() {
		return ccAppRepo.maritalDemographics();
	}

	public List<IHouseholdDemographics> householdSizeDemographics() {
		return ccAppRepo.householdsizeDemographics();
	}

	public List<IGenderDemographic> genderDemographic() {
		return ccAppRepo.genderDemographic(); 
	}

	public List<IRegionSale> regionalSales() {
		return ccAppRepo.regionalSales();
	}

	
	
}
