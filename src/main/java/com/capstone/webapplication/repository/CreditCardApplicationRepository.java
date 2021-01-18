package com.capstone.webapplication.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.capstone.webapplication.dto.*;

import com.capstone.webapplication.entity.CreditCardApplication;






@Repository
public interface CreditCardApplicationRepository extends JpaRepository<CreditCardApplication, Integer>{
	
	//if there is time these need to be changed to jpql queries
	
	//2. Count of credit cards by day, month, year
	@Query(value = "SELECT credit_card_application_apply_date as applicationDate, count(*) as countOfApplication FROM credit_card_application WHERE date(credit_card_application_apply_date) = date(?1)", nativeQuery = true)
	List<IDateCount> countApplicationsByDate(Date day); 
	@Query(value = "select monthname(credit_card_application_apply_date)  as applicationDate , count( * ) as countOfApplication FROM credit_card_application GROUP BY month(credit_card_application_apply_date)", nativeQuery = true)
	List<IDateCount> countApplicationsByMonth(); 
	@Query(value = "select year(credit_card_application_apply_date)  as applicationDate , count( * ) as countOfApplication FROM credit_card_application GROUP BY YEAR(credit_card_application_apply_date)", nativeQuery = true)
	List<IDateCount>  countApplicationsByYear(); 

	//3. Status of all cc prospects
	@Query(value = "select credit_card_application_id as cCApplicationId, credit_card_pending_description as pendingStatus from credit_card_application where credit_card_application_status = 'P'", nativeQuery = true)
	List<IPendingDetail> prospectDetails(); 
	
	//4. No of credit cards approved, region wise / profession wise
	@Query(value = "select c.region as region, count(*) as countOfApplication from customers c inner join credit_card_application "
			+ "ccapp on c.credit_card_application_credit_card_application_id = ccapp.credit_card_application_id group by c.region", nativeQuery = true)
	List<IRegionCount> countApprovedByRegion();
	
	@Query(value = "select cu.employment as employment, count(*) as countOFApplication from customers cu inner join credit_card_application cca "
			+ "on cu.credit_card_application_credit_card_application_id = cca.credit_card_application_id GROUP BY cu.employment", nativeQuery = true)
	List<IEmploymentCount> countApprovedByEmployment(); 
	
	//4, 5 Status details
	@Query(value = "SELECT credit_card_application_id as cCApplicationId, credit_card_rejected_description as rejectedReason FROM credit_card_application where credit_card_application_status = 'R'", nativeQuery = true)
	List<IRejectedReason> rejectedDetails(); 
	@Query(value = "select credit_card_application_id as cCApplicationId, credit_card_accepted_description as approvedReason from credit_card_application where credit_card_application_status = 'A'", nativeQuery = true)
	List<IApprovedReason> approvedDetails(); 

	//10
	@Query(value = "SELECT AVG(DATEDIFF(credit_card_application_approval_date, credit_card_application_apply_date)) as averageDaysToApprove from credit_card_application WHERE credit_card_application_status = 'A'", nativeQuery = true)
	IApproveReponseTime averageTimeToApprove();
	@Query(value = "SELECT AVG(DATEDIFF(credit_card_application_rejection_date, credit_card_application_apply_date)) as averageDaysToReject from credit_card_application WHERE credit_card_application_status = 'R'", nativeQuery = true)
	IRejectReponseTime averageTimeToReject();
	
	
	//15
	@Query(value = "SELECT SUM(IF(marital_status = 'M', 1, 0)) AS countOfMarried, SUM(IF(marital_status = 'S', 1, 0)) AS countOfSingle FROM customers; ", nativeQuery = true)
	IMaritalDemographic maritalDemographics();
	
	@Query(value = "select count(*) as countOfSize, household_size as householdSize from customers group by household_size ", nativeQuery = true)
	List<IHouseholdDemographics> householdsizeDemographics();
	
	@Query(value = "select count(*) as numberOfCustomers, gender as gender from customers group by gender", nativeQuery = true)
	List<IGenderDemographic> genderDemographic();
	
	@Query(value = "select count(*) as numberOfCustomers, region as region from customers group by region", nativeQuery = true)
	List<IRegionSale> regionalSales();
	
	
	
	
}