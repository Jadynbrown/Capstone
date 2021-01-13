package com.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.domain.CreditCardApplication;



@Repository
public interface CreditCardApplicationRepository extends JpaRepository<CreditCardApplication, Integer>{
	
	//2. Count of credit cards by day, month, year
	@Query(value = "SELECT count(*) FROM credit_card_application WHERE date(credit_Card_Application_Apply_Date) = date(?1)", nativeQuery = true)
	List<Object> countApplicationsByDate(Date day); 
	@Query(value = "select monthname(credit_Card_Application_Apply_Date), count( * ) FROM credit_card_application GROUP BY month(credit_Card_Application_Apply_Date)", nativeQuery = true)
	List<Object> countApplicationsByMonth(); 
	@Query(value = "select year(credit_Card_Application_Apply_Date), count( * ) FROM credit_card_application GROUP BY YEAR(credit_Card_Application_Apply_Date)", nativeQuery = true)
	List<Object> countApplicationsByYear(); 

	//3. Status of all cc prospects
	@Query(value = "select * from credit_card_application where credit_Card_Application_Status = 'P'", nativeQuery = true)
	List<CreditCardApplication> prospectDetails(); 
	
	//4. No of credit cards approved, region wise / profession wise
	@Query(value = "select c.region, count(*) from test.customer c inner join test.credit_card_application ccapp  \n"
			+ "on c.credit_Card_Application_Id = ccapp.credit_Card_Application_Id group by c.region;", nativeQuery = true)
	List<Object> countApprovedByRegion();
	
	//if there is time these need to be changed to jpql queries
	@Query(value = "select c.employment, count(*) from customer c inner join credit_card_application ccapp  \n"
			+ " on c.credit_Card_Application_Id = ccapp.credit_Card_Application_Id group by c.employment", nativeQuery = true)
	List<Object> countApprovedByEmployment(); 
	
	//4, 5 Status details
	@Query(value = "SELECT * FROM credit_card_application where credit_Card_Application_Status = 'R'", nativeQuery = true)
	List<CreditCardApplication> rejectedDetails(); 
	@Query(value = "select * from credit_card_application where credit_Card_Application_Status = 'A'", nativeQuery = true)
	List<CreditCardApplication> approvedDetails(); 

	//10. No of credit card rejected along with reasons
	@Query(value = "SELECT AVG(DATEDIFF(credit_Card_Application_Approval_Date, credit_Card_Application_Apply_Date)) as AvgDateDifference from credit_card_application WHERE credit_Card_Application_Approval_Date IS NOT NULL", nativeQuery = true)
	List<Object> averageTimeToApprove();
	
	
	
	
}


/*
	
*/