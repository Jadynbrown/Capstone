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

import com.capstone.webapplication.dto.IIncomeCount;
import com.capstone.webapplication.dto.IMaritalStatusCount;
import com.capstone.webapplication.dto.INameReason;
import com.capstone.webapplication.dto.IStateCount;
import com.capstone.webapplication.entity.CreditCard;
import com.capstone.webapplication.service.CreditCardService;

@RestController
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;

	@PostMapping("/creditcards")
	public CreditCard addCreditCard(@RequestBody CreditCard creditCard) {
		return creditCardService.saveCreditCard(creditCard);
	}

	

	@GetMapping("/creditcards")
	@ResponseBody
	public List<CreditCard> findAllCreditCards() {
		return creditCardService.getCreditCards();
	}

	@GetMapping("/creditcards/types")
	@ResponseBody
	public List<String> findCreditCardtypes() {
		return creditCardService.getCreditCardType();
	}
	
	@GetMapping("/creditcards/discontinued/income")
	@ResponseBody
	public List<IIncomeCount> getCountByIncomeCounts() {
		return creditCardService.getCountByIncomeCounts();
	}
	
	@GetMapping("/creditcards/discontinued/state")
	@ResponseBody
	public List<IStateCount> getCountByState() {
		return creditCardService.getCountByState();
	}
	
	@GetMapping("/creditcards/discontinued/maritalstatus")
	@ResponseBody
	public List<IMaritalStatusCount> getCountByMaritalStatus() {
		return creditCardService.getCountByMaritalStatus();
	}
	
	@GetMapping("/creditcards/discontinued/reason")
	@ResponseBody
	public List<INameReason> getNameAndReason() {
		return creditCardService.getNameAndReason();
	}


	@GetMapping("/creditcards/expiry")
	@ResponseBody
	public List<CreditCard> findCreditCardsExpiring() {
		return creditCardService.getCreditCardExpiring();
	}

	@GetMapping("/creditcards/{id}")
	public ResponseEntity<CreditCard> findCreditCardById(@PathVariable(value = "id") Integer id) {
		CreditCard creditCard = creditCardService.getCreditCardById(id);
		if (creditCard == null) {
			return ResponseEntity.notFound().build();

		}
		return ResponseEntity.ok().body(creditCard);
	}

	@DeleteMapping("/creditcard/{id}")
	public String deleteCreditCard(@PathVariable Integer id) {
		return creditCardService.deleteCreditCard(id);
	}

}
