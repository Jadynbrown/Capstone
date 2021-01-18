package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.Transaction;



@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
