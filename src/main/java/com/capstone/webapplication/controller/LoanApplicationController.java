package com.capstone.webapplication.controller;

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
import com.capstone.webapplication.dto.*;
import com.capstone.webapplication.entity.LoanApplication;
import com.capstone.webapplication.entity.Customer;
import com.capstone.webapplication.service.LoanApplicationService;
import com.capstone.webapplication.service.LoanApplicationService;


@RestController
@RequestMapping("/loanapplications")
public class LoanApplicationController {
	
	@Autowired
	LoanApplicationService loanAppBo;
	
	@GetMapping
	public List<LoanApplication> getLoanApplications(){
		return loanAppBo.getLoanApplications(); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LoanApplication> getLoanApplicationById(@PathVariable(value = "id") Integer id){
		LoanApplication loanApp = loanAppBo.getLoanApplicationById(id);
		if(loanApp == null) {
			return ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok().body(loanApp);
	}
	//Adds the given Loan application to the db
	@PostMapping
	public Customer addLoanApplications(@RequestBody LoanApplication loanApp, @RequestParam int customerid) {
		return loanAppBo.addLoanApplication(loanApp, customerid);
	}
	
	//Updates the loan application with the given id to match the given card
	//throws NoSuchElementException
	@PutMapping("/{id}")
	public Customer updateLoanApplication(@RequestBody LoanApplication loanApp, @PathVariable int id) {
		return loanAppBo.updateLoanApplication(loanApp, id);
	}
	
	//throws NoSuchElementException
	@DeleteMapping("/{id}")
	public Customer deleteLoanApplicationById(@PathVariable int id) {
		return loanAppBo.deleteLoanApplicationById(id);
	}
	//#2, #4  		Still need error handling on this
	@GetMapping(params = "countby")
	public List<IDateCount>  getLoanCardCount(@RequestParam String countby){
		System.out.println(countby  + "count by ");
		switch (countby.toLowerCase()) {
			case "month": 
				return loanAppBo.countApplicationsByMonth();
			case "year": 
				return loanAppBo.countApplicationsByYear();
			default: //Specific date accepted - need error handling here
				return loanAppBo.countApplicationsByDate(countby);
		}
	} 
	
	@GetMapping("/approved/region")
	public List<IRegionCount> getRegionCount() {
		return loanAppBo.countApprovedByRegion();
	}
	@GetMapping("/approved/employment")
	public List<IEmploymentCount> getEmploymentCount() {
		return loanAppBo.countApprovedByEmployment();
	}
	
	@GetMapping("/approved/details")
	public List<IApprovedReason> getApprovedReasons() {
		return loanAppBo.approvedDetails();
	}
	@GetMapping("/rejected/details")// #3, 5
	public List<IRejectedReason> getRejectedReasons() {
		return loanAppBo.rejectedDetails();
	}
	@GetMapping("/pending/details")
	public List<IPendingDetail> getPendingStatus() {
		return loanAppBo.prospectDetails();
	}
	
	
	//#10 
	@GetMapping("/averageresponsetime/reject") //This is returning the application ID out of order compared to approved/rejected
	public IRejectReponseTime getAverageTimeToReject() {
		return loanAppBo.averageTimeToReject();
	}
	@GetMapping("/averageresponsetime/approve")
	public IApproveReponseTime getAverageTimeToApprove() {
		return loanAppBo.averageTimeToApprove();
	}
		

}