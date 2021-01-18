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

	@PostMapping("/creditCards")
	public CreditCard addCreditCard(@RequestBody CreditCard creditCard) {
		return creditCardService.saveCreditCard(creditCard);
	}

	@PostMapping("/CreditCards")
	public List<CreditCard> addCreditCards(@RequestBody List<CreditCard> creditCards) {
		return creditCardService.saveCreditCards(creditCards);
	}

	@GetMapping("/creditCards")
	@ResponseBody
	public List<CreditCard> findAllCreditCards() {
		return creditCardService.getCreditCards();
	}

	@GetMapping("/creditCards/types")
	@ResponseBody
	public List<String> findCreditCardtypes() {
		return creditCardService.getCreditCardType();
	}
	
	@GetMapping("/creditCards/disContinued/income")
	@ResponseBody
	public List<IIncomeCount> getCountByIncomeCounts() {
		return creditCardService.getCountByIncomeCounts();
	}
	
	@GetMapping("/creditCards/disContinued/state")
	@ResponseBody
	public List<IStateCount> getCountByState() {
		return creditCardService.getCountByState();
	}
	
	@GetMapping("/creditCards/disContinued/maritalStatus")
	@ResponseBody
	public List<IMaritalStatusCount> getCountByMaritalStatus() {
		return creditCardService.getCountByMaritalStatus();
	}
	
	@GetMapping("/creditCards/disContinued/reason")
	@ResponseBody
	public List<INameReason> getNameAndReason() {
		return creditCardService.getNameAndReason();
	}


	@GetMapping("/creditCards/expiry")
	@ResponseBody
	public List<CreditCard> findCreditCardsExpiring() {
		return creditCardService.getCreditCardExpiring();
	}

	@GetMapping("/creditCards/{id}")
	public ResponseEntity<CreditCard> findCreditCardById(@PathVariable(value = "id") Integer id) {
		CreditCard creditCard = creditCardService.getCreditCardById(id);
		if (creditCard == null) {
			return ResponseEntity.notFound().build();

		}
		return ResponseEntity.ok().body(creditCard);
	}

	@DeleteMapping("/creditCard/{id}")
	public String deleteCreditCard(@PathVariable Integer id) {
		return creditCardService.deleteCreditCard(id);
	}

}
