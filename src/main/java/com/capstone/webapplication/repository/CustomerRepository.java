package com.capstone.webapplication.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capstone.webapplication.dto.INameLimit;
import com.capstone.webapplication.dto.IGenderDemographic;
import com.capstone.webapplication.dto.IHouseholdDemographics;
import com.capstone.webapplication.dto.IMaritalDemographic;
import com.capstone.webapplication.dto.INameCcIdClassification;
import com.capstone.webapplication.dto.INameSpendingClassification;
import com.capstone.webapplication.dto.IRegionSale;
import com.capstone.webapplication.entity.CreditCard;
import com.capstone.webapplication.entity.Customer;
import com.capstone.webapplication.entity.Transaction;


public interface CustomerRepository  extends JpaRepository<Customer, Integer>{
	
	

	@Query(value= "SELECT * FROM credit_card  WHERE customer_customer_id = ?1",nativeQuery = true)
	CreditCard findByCreditCardCreditCardId(Integer customer_Id);
	
			
	@Query(value= "select cu.name as customerName, cc.credit_card_limit as creditCardLimit from customers cu INNER JOIN credit_card cc on cu.customer_id = cc.customer_customer_id",nativeQuery = true)
	public List<INameLimit> findBalanceByCustomer();
	

	
	@Query(value= "SELECT t.credit_card_credit_card_id as creditCardId, cu.name as customerName, SUM(t.payment_default) as missedPayment, CASE WHEN  SUM(payment_default) >= 2 THEN \"Bad customer\" \r\n" + 
			"WHEN SUM(payment_default) < 2 THEN \"Good Customer\" END AS customerClassification\r\n" + 
			"FROM\r\n" + 
			"(select credit_card_credit_card_id, \r\n" + 
			"CASE WHEN  payment_due_date >= payment_date THEN 0\r\n" + 
			"WHEN payment_due_date < payment_date THEN 1 END AS payment_default\r\n" + 
			"FROM payment WHERE payment_due_date >= date_sub(now(), interval 6 month)) t inner join credit_card cc on cc.credit_card_id = t.credit_card_credit_card_id \r\n" + 
			"join customers cu on cu.customer_id = cc.customer_customer_id \r\n" + 
			"GROUP BY t.credit_card_credit_card_id",nativeQuery = true)
	public List<INameCcIdClassification> findClassificationByPayment();
	
	
	@Query(value= "select cu.name as customerName, cc.credit_card_id as creditCardId , SUM(t.cost) as totalSpending ,\r\n" + 
			"CASE WHEN SUM(t.cost) >= 5000 THEN \"High Value Customer\"\r\n" + 
			"WHEN SUM(t.cost) <5000 AND SUM(t.cost) >=2500 THEN \"Medicore Customer\"\r\n" + 
			"WHEN SUM(t.cost) < 2500 THEN \"Low Value Customer\" END AS customerClassification\r\n" + 
			"FROM transaction_tbl t inner join credit_card cc on cc.credit_card_id = t.credit_card_credit_card_id \r\n" + 
			"join customers cu on cu.customer_id = cc.customer_customer_id WHERE transaction_date >= date_sub(now(), interval 6 month)\r\n" + 
			"GROUP BY t.credit_card_credit_card_id",nativeQuery = true)
	public List<INameSpendingClassification> findClassificationBySpending();

	@Query(value = "SELECT SUM(IF(marital_status = 'M', 1, 0)) AS countOfMarried, SUM(IF(marital_status = 'S', 1, 0)) AS countOfSingle FROM customers; ", nativeQuery = true)
	IMaritalDemographic maritalDemographics();
	
	@Query(value = "select count(*) as countOfSize, household_size as householdSize from customers group by household_size ", nativeQuery = true)
	List<IHouseholdDemographics> householdsizeDemographics();
	
	@Query(value = "select count(*) as numberOfCustomers, gender as gender from customers group by gender", nativeQuery = true)
	List<IGenderDemographic> genderDemographic();
	
	@Query(value = "select count(*) as numberOfCustomers, region as region from customers group by region", nativeQuery = true)
	List<IRegionSale> regionalSales();
	
	
}	