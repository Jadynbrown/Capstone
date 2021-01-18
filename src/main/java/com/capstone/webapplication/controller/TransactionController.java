package com.capstone.webapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.webapplication.dto.IStateCost;
import com.capstone.webapplication.dto.ITypeCost;
import com.capstone.webapplication.entity.CreditCard;
import com.capstone.webapplication.entity.Transaction;
import com.capstone.webapplication.service.CreditCardService;
import com.capstone.webapplication.service.TransactionService;




@RestController	
public class TransactionController {
	
	@Autowired
	private TransactionService transactionData;
	@Autowired
	private CreditCardService creditCardService; 
	
	@GetMapping("/creditCards/{creditCardId}/transactions")
	public ResponseEntity<List<Transaction>> getTransactions(@PathVariable Integer creditCardId){
		return ResponseEntity.ok(transactionData.getTransactions(creditCardId));
	}
	
	@GetMapping("/creditCards/{creditCardId}/transactions/cost/{transactionType}")
	public ITypeCost getCostByTransaction(@PathVariable("creditCardId") Integer creditCardId, @PathVariable("transactionType") String transactionType) 
	{
		return transactionData.getCostByTransaction(creditCardId, transactionType);
	}
	
	@GetMapping("/creditCards/{creditCardId}/transactions/region/{transactionState}")
	public List<Transaction> getTransactionByState(@PathVariable("creditCardId") Integer creditCardId, @PathVariable("transactionState") String transactionState) 
	{
		return transactionData.getTransactionByState(creditCardId, transactionState);
	}
	
	@GetMapping("/creditCards/{creditCardId}/transactions/region")
	public List<IStateCost> getAllTransactionByRegion(@PathVariable("creditCardId") Integer creditCardId) 
	{
		return transactionData.getAllTransactionByRegion(creditCardId);
	}
	
	//Url for credit card statement - requirement6
	@GetMapping("/creditCards/{creditCardId}/transactions/{month}/{year}")
	public List<Transaction> getStatementByDate(@PathVariable Integer creditCardId, @PathVariable Integer month, @PathVariable Integer year ) 
	{
		return transactionData.getStatementByDate(creditCardId, month,year);
	}
	
	@GetMapping("/creditCards/{creditCardId}/transactions/{transactionId}")
	public Transaction getTransaction(@PathVariable Integer transactionId)
	{
		return transactionData.getTransaction(transactionId);
	}
	
	@PostMapping( "/creditCards/{creditCardId}/transactions")
	public Transaction addCreditCard(@RequestBody Transaction transaction, @PathVariable Integer creditCardId)
	{  
		transaction.setCreditCard(new CreditCard(creditCardId));
		return transactionData.addTransaction(transaction);
		
		
	}
	
	
}