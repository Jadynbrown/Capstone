package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.CreditCardApplication;
import com.domain.Customer;
import com.domain.StatusDetails;
import com.domain.WaitTimeResponse;
import com.bo.CreditCardApplicationBO;



@RestController
@RequestMapping("/cardapplications")
public class CreditCardApplicationController {
	
	@Autowired
	CreditCardApplicationBO ccAppBo;
	Customer c = new Customer(); 
	
	
	@GetMapping
	public List<CreditCardApplication> getCreditCardApplications(){
		return ccAppBo.getCreditCardApplications(); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CreditCardApplication> getCreditCardApplicationById(@PathVariable(value = "id") Integer id){
		CreditCardApplication ccApp = ccAppBo.getCreditCardApplicationById(id);
		if(ccApp == null) {
			return ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok().body(ccApp);
	}
	//Adds the given creditcardapplication to the db
	@PostMapping
	public void addCreditCardApplications(@RequestBody CreditCardApplication ccApp) {
		ccAppBo.addCreditCardApplication(ccApp);
	}
	
	//Updates a given creditCardApplication
	@PutMapping("/{id}")
	public void updateCresditCardApplication(@RequestBody CreditCardApplication ccApp) {
		ccAppBo.updateCreditCardApplication(ccApp);
	}
	
	//
	@DeleteMapping("/{id}")
	public void deleteCreditCardApplicationById(@PathVariable int id) {
		ccAppBo.deleteCreditCardApplicationById(id);
	}
	//#2, #4  		Still need error handling on this
	@GetMapping(params = {"countby"})
	public List<Object>  getCreditCardCount(@RequestParam String countby){
		switch (countby.toLowerCase()) {
			case "month": 
				return ccAppBo.countApplicationsByMonth();
			case "year": 
				return ccAppBo.countApplicationsByYear();
			case "employment":
				return ccAppBo.countApprovedByEmployment();
			case "region":
				return ccAppBo.countApprovedByRegion();
			default: //Specific date accepted - need error handling here
				return ccAppBo.countApplicationsByDate(countby);
		}
	} 
	
	@GetMapping(params = "status")//#3, #5
	public StatusDetails getApplicantStatuses(@RequestParam String status){
		if(status.toLowerCase().equals("pending")) {
			return new StatusDetails(ccAppBo.prospectDetails());
		}
		if(status.toLowerCase().equals("rejected")) {
			return new StatusDetails(ccAppBo.rejectedDetails());
		}
		if(status.toLowerCase().equals("approved")) {
			return new StatusDetails(ccAppBo.approvedDetails());
		}
		else
			return null; 
	}
	
	// need 9, 11, 12, 13, 14, 15, 16?
	//#10
	@GetMapping(params = "averageof")
	public List<WaitTimeResponse>  getAverageTimeToApprove(@RequestParam String averageof){
		if(averageof.toLowerCase().equals("approved")) {
			return ccAppBo.averageTimeToApprove();
		}else if (averageof.toLowerCase().equals("rejected")){
			return ccAppBo.averageTimeToReject();
		}else {
			//throw error
			return null; 
		}
		
	}


}
