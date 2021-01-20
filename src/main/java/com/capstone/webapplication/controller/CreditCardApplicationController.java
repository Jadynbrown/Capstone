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
import com.capstone.webapplication.entity.CreditCardApplication;
import com.capstone.webapplication.entity.Customer;
import com.capstone.webapplication.service.CreditCardApplicationService;


@RestController
@RequestMapping("/cardapplications")
public class CreditCardApplicationController {
	
	@Autowired
	CreditCardApplicationService ccAppBo;
	
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
	//Adds the given credit card application to the db
	@PostMapping
	public Customer addCreditCardApplications(@RequestBody CreditCardApplication ccApp, @RequestParam int customerid) {
		return ccAppBo.addCreditCardApplication(ccApp, customerid);
	}
	
	//Updates the creditcard application with the given id to match the given card
	//throws NoSuchElementException
	@PutMapping("/{id}")
	public Customer updateCreditCardApplication(@RequestBody CreditCardApplication ccApp, @PathVariable int id) {
		return ccAppBo.updateCreditCardApplication(ccApp, id);
	}
	
	//throws NoSuchElementException
	@DeleteMapping("/{id}")
	public Customer deleteCreditCardApplicationById(@PathVariable int id) {
		return ccAppBo.deleteCreditCardApplicationById(id);
	}
	//#2, #4  		Still need error handling on this
	@GetMapping(params = "countby")
	public List<IDateCount>  getCreditCardCount(@RequestParam String countby){
		System.out.println(countby  + "count by ");
		switch (countby.toLowerCase()) {
			case "month": 
				return ccAppBo.countApplicationsByMonth();
			case "year": 
				return ccAppBo.countApplicationsByYear();
			default: //Specific date accepted - need error handling here
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-DD");
				return ccAppBo.countApplicationsByDate((countby));
		}
	} 
	
	@GetMapping("/approved/region")
	public List<IRegionCount> getRegionCount() {
		return ccAppBo.countApprovedByRegion();
	}
	@GetMapping("/approved/employment")
	public List<IEmploymentCount> getEmploymentCount() {
		return ccAppBo.countApprovedByEmployment();
	}
	
	@GetMapping("/approved/details")
	public List<IApprovedReason> getApprovedReasons() {
		return ccAppBo.approvedDetails();
	}
	@GetMapping("/rejected/details")// #3, 5
	public List<IRejectedReason> getRejectedReasons() {
		return ccAppBo.rejectedDetails();
	}
	@GetMapping("/pending/details") //This is returning the application ID out of order compared to approved/rejected
	public List<IPendingDetail> getPendingStatus() {
		return ccAppBo.prospectDetails();
	}
		
	//#10 
	@GetMapping("/averageresponsetime/reject") //This is returning the application ID out of order compared to approved/rejected
	public IRejectReponseTime getAverageTimeToReject() {
		return ccAppBo.averageTimeToReject();
	}
	@GetMapping("/averageresponsetime/approve")
	public IApproveReponseTime getAverageTimeToApprove() {
		return ccAppBo.averageTimeToApprove();
	}
	
	//#14: Region wise sale of credit card
	@GetMapping("/regionalsales")
	public List<IRegionSale> getRegionalSales() {
		return ccAppBo.regionalSales();
	}
	


}