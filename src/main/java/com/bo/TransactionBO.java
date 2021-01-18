package com.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Transaction;
import com.dao.TransactionRepository;


@Service
public class TransactionBO {
	@Autowired
	TransactionRepository tRepo; 
	
	public List<Transaction> getTransactions(){
		return tRepo.findAll(); 		
	}
	
	public void addTransaction(Transaction tx) {
		tRepo.save(tx); 
	}
	
	public void deleteTransaction(int txId) {
		tRepo.deleteById(txId);
	}
}
