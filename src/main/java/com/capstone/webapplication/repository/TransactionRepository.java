package com.capstone.webapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capstone.webapplication.dto.IStateCost;
import com.capstone.webapplication.dto.ITypeCost;
import com.capstone.webapplication.entity.Transaction;



public interface TransactionRepository  extends JpaRepository<Transaction, Integer>{
	
	List<Transaction> findByCreditCardCreditCardId(Integer creditCardId);
	

	@Query(value= "SELECT t.transaction_type as transactionType, SUM(cost) as cost  FROM transaction_tbl t INNER JOIN credit_card c on t.credit_card_credit_card_id = c.credit_card_id WHERE c.credit_card_id = ?1 AND t.transaction_type = ?2 GROUP BY  t.transaction_type",nativeQuery = true)
	public ITypeCost findCostByTransactiontype(Integer creditCardId, String transactionType );
	
	
	
	@Query(value= "select * from transaction_tbl  where credit_card_credit_card_id = ?1 and MONTH(transaction_date) = ?2 and YEAR(transaction_date) = ?3" , nativeQuery = true )
	public List<Transaction> findStatementByDate(Integer creditCardId, Integer month, Integer year);
	
	@Query(value= "SELECT t.*  FROM transaction_tbl t INNER JOIN credit_card c on t.credit_card_credit_card_id = c.credit_card_id WHERE c.credit_card_id = ?1 AND t.transaction_state = ?2",nativeQuery = true)
	public List<Transaction> findTransactionByState(Integer creditCardId, String transactionState );
	
	@Query(value= "SELECT t.transaction_state as transactionState, SUM(cost) as cost FROM transaction_tbl t INNER JOIN credit_card c on t.credit_card_credit_card_id = c.credit_card_id WHERE c.credit_card_id = ?1 GROUP BY  t.transaction_state",nativeQuery = true)
	public List<IStateCost> findAllTransactionByRegion(Integer creditCardId );
	
}
