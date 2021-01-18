package com.capstone.webapplication.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capstone.webapplication.dto.IIncomeCount;
import com.capstone.webapplication.dto.IMaritalStatusCount;
import com.capstone.webapplication.dto.INameReason;
import com.capstone.webapplication.dto.IStateCount;
import com.capstone.webapplication.entity.CreditCard;


public interface CreditCardRepository  extends JpaRepository<CreditCard, Integer>{
	
	@Query(value= "select * from credit_card where datediff(expiration_date, curdate() ) < 90", nativeQuery = true)
	public List<CreditCard> findExpiryCreditCard();
	
	@Query(value= "select distinct(credit_card_type) from credit_card", nativeQuery = true)
	public List<String> findByCreditCardType();
	
	@Query(value= "SELECT \r\n" + 
			" CASE WHEN cu.income < 30000 THEN \"Lower-class\"\r\n" + 
			" WHEN cu.income  >=30000 AND cu.income  <50000 THEN \"Lower-middle-class\"\r\n" + 
			" WHEN cu.income  >=50000 AND cu.income  <75000 THEN \"Middle-class\"\r\n" + 
			" WHEN cu.income >=75000 THEN \"Upper-class\"\r\n" + 
			" END AS IncomeType, COUNT(*) as disContinuedCount FROM customers cu INNER JOIN credit_card  cc on cc.customer_customer_id = cu.customer_id WHERE cc.status  = 0 GROUP BY IncomeType", nativeQuery = true)
	public List<IIncomeCount> findCountByIncomeType();
	
	@Query(value= "select cu.state as state, count(*) as disContinuedCount from credit_card cc inner join customers cu on cc.customer_customer_id = cu.customer_id where cc.status  = 0 group by cu.state", nativeQuery = true)
	public List<IStateCount> findCountByState();
	
	@Query(value= "select cu.marital_status as maritalStatus, count(*) as disContinuedCount from credit_card cc inner join customers cu on cc.customer_customer_id = cu.customer_id where cc.status  = 0 group by cu.marital_status", nativeQuery = true)
	public List<IMaritalStatusCount> findCountByMaritalStatus();
	
	@Query(value= "select cu.name, cc.discontinued_reason as disContinuedReason from credit_card cc inner join customers cu on cc.customer_customer_id = cu.customer_id where cc.status  = 0", nativeQuery = true)
	public List<INameReason> findByNameAndReason();
	
	
	
	
	
	
	
}
