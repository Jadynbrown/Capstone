package com.capstone.webapplication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.webapplication.dto.IStateCost;
import com.capstone.webapplication.dto.ITypeCost;
import com.capstone.webapplication.entity.Transaction;
import com.capstone.webapplication.repository.TransactionRepository;



@Service
public class TransactionService {

@Autowired
private TransactionRepository transactionRepo;
	
	public List<Transaction> getTransactions(Integer creditCardId)
	{
		return transactionRepo.findByCreditCardCreditCardId(creditCardId);
	}

	public Transaction getTransaction(Integer transactionId) {
		
		 //topics.stream().filter(topic-> topic.getId().equals(id)).findFirst().get();
		Optional<Transaction> res=transactionRepo.findById(transactionId);
		
		return res.get();
	}

	public Transaction addTransaction(Transaction transaction) {
		transactionRepo.save(transaction);
		
		return transaction;
	}
	
	public ITypeCost getCostByTransaction(Integer creditCardId, String transactionType) {
		
		return  transactionRepo.findCostByTransactiontype(creditCardId, transactionType);
		
	}
	public List<IStateCost> getAllTransactionByRegion(Integer creditCardId) {
		
		return  transactionRepo.findAllTransactionByRegion(creditCardId);
		
	}
	
	public List<Transaction> getTransactionByState(Integer creditCardId, String transactionState) {
		
		return  transactionRepo.findTransactionByState(creditCardId, transactionState);
		
	}
	
	public List<Transaction> getStatementByDate(Integer creditCardId, Integer month, Integer year) {
		
		 //topics.stream().filter(topic-> topic.getId().equals(id)).findFirst().get();
		return transactionRepo.findStatementByDate(creditCardId, month, year);		
	}

	
}