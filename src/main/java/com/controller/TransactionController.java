package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Transaction;
import com.bo.TransactionBO;




@RestController
@RequestMapping("/transactions")
public class TransactionController{
	
	@Autowired
	TransactionBO tbo; 
	
	@GetMapping
	public List<Transaction> getTransactions(){
		return tbo.getTransactions(); 
	}
	
	@PostMapping
	public void addCreditCard(@RequestBody Transaction tx) {
		tbo.addTransaction(tx);
	}
	
	@DeleteMapping
	public void deleteCreditCard(@RequestBody int txId) {
		tbo.deleteTransaction(txId);
	}
}
