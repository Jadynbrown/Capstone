package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository <CreditCard, Integer> {
  /*
   * Credit card statements, Types of Credit cards.
		7. Credit card usage/spend pattern – E.g., Grocery/ Fitness/ Entertainment etc.
		8. Credit card limits customer wise
		9. Credit card payment history along with the limits
		Credit card expiring in next 3 months
		13. Region wise usage of Credit card
		14. Region wise sale of credit card
 */
	//13. Region wise usage of Credit card
	
}
