package com.capstone.webapplication.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.capstone.webapplication.dto.*;

import com.capstone.webapplication.entity.CreditCardApplication;
import com.capstone.webapplication.entity.LoanApplication;






@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Integer>{
	
	//if there is time these need to be changed to jpql queries
	
	//2. Count of credit cards by day, month, year
	@Query(value = "SELECT loan_application_apply_date as applicationDate, count(*) as countOfApplication FROM loan_application WHERE date(loan_application_apply_date) = ?1", nativeQuery = true)
	List<IDateCount> countApplicationsByDate(Date day); 
	@Query(value = "select monthname(loan_application_apply_date)  as applicationDate , count( * ) as countOfApplication FROM loan_application GROUP BY month(loan_application_apply_date)", nativeQuery = true)
	List<IDateCount> countApplicationsByMonth(); 
	@Query(value = "select year(loan_application_apply_date)  as applicationDate , count( * ) as countOfApplication FROM loan_application GROUP BY YEAR(loan_application_apply_date)", nativeQuery = true)
	List<IDateCount>  countApplicationsByYear(); 

	//3. Status of all cc prospects
	@Query(value = "select loan_application_id as applicationId, loan_pending_description as pendingStatus from loan_application where loan_application_status = 'P'", nativeQuery = true)
	List<IPendingDetail> prospectDetails(); 
	
	//4. No of credit cards approved, region wise / profession wise
	@Query(value = "select c.region as region, count(*) as countOfApplication from customers c inner join loan_application "
			+ "ccapp on c.loan_application_loan_application_id = ccapp.loan_application_id  WHERE loan_application_status = 'A' group by c.region", nativeQuery = true)
	List<IRegionCount> countApprovedByRegion();
	
	@Query(value = "select cu.employment as employment, count(*) as countOFApplication from customers cu inner join loan_application cca "
			+ "on cu.loan_application_loan_application_id = cca.loan_application_id  WHERE loan_application_status = 'A' GROUP BY cu.employment", nativeQuery = true)
	List<IEmploymentCount> countApprovedByEmployment(); 
	
	//4, 5 Status details
	@Query(value = "SELECT loan_application_id as applicationId, loan_rejected_description as rejectedReason FROM loan_application where loan_application_status = 'R'", nativeQuery = true)
	List<IRejectedReason> rejectedDetails(); 
	@Query(value = "select loan_application_id as applicationId, loan_accepted_description as approvedReason from loan_application where loan_application_status = 'A'", nativeQuery = true)
	List<IApprovedReason> approvedDetails(); 

	//10
	@Query(value = "SELECT AVG(DATEDIFF(loan_application_approval_date, loan_application_apply_date)) as averageDaysToApprove from loan_application WHERE loan_application_status = 'A'", nativeQuery = true)
	IApproveReponseTime averageTimeToApprove();
	@Query(value = "SELECT AVG(DATEDIFF(loan_application_rejection_date, loan_application_apply_date)) as averageDaysToReject from loan_application WHERE loan_application_status = 'R'", nativeQuery = true)
	IRejectReponseTime averageTimeToReject();
	
	
	
	
}