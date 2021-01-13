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
import com.domain.StatusDetails;
import com.bo.CreditCardApplicationBO;



@RestController
@RequestMapping("/creditcardapplications")
public class CreditCardApplicationController {
	
	@Autowired
	CreditCardApplicationBO ccAppBo; 
	
	
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
	
	@PostMapping
	public void addCreditCardApplications(@RequestBody CreditCardApplication ccApp) {
		ccAppBo.addCreditCardApplication(ccApp);
	}
	
	@PutMapping("/{id}")
	public void updateCreditCardApplication(@RequestBody CreditCardApplication ccApp) {
		ccAppBo.updateCreditCardApplication(ccApp);
	}
	

	@DeleteMapping
	public void deleteCreditCardApplicationById(@RequestBody int ccAppId) {
		ccAppBo.deleteCreditCardApplicationById(ccAppId);
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

		
//	@GetMapping("/averageapprovaltime", params = {"countby"})
//	public List<Object>  getAverageTimeToApprove(){
//		return ccAppBo.averageTimeToApprove();
//	}


}