# Capstone
@Entiteam's Lankaster banking solution

Requirements Along with URL’s
2) No. of Credit Card and Loan request received daily weekly monthly
    http://localhost:8081/cardapplications?countby=year
    http://localhost:8081/cardapplications?countby=month
    http://localhost:8081/cardapplications?countby=2019-01-01
3) Status of the application for Credit Card / Loan for every prospect
    http://localhost:8081/cardapplications/pending/details
4) No of credit card approved, region wise/ profession wise
    http://localhost:8081/cardapplications/approved/region
    http://localhost:8081/cardapplications/approved/employment
5) No of credit card rejected along with reasons
    http://localhost:8081/cardapplications/rejected/details
    http://localhost:8081/cardapplications/approved/details
6) Credit card statements, Types of Credit cards
a) Credit card statements
    http://localhost:8081/creditcards/1/transactions/06/2020
    http://localhost:8081/creditcards/1/transactions/12/2020
b) Types of Credit cards
    http://localhost:8081/creditcards/types
7) Credit card usage/spend pattern – E.g., Grocery/ Fitness/ Entertainment etc – It takes Spending as parameter and returns the spend type and total amount spent
    http://localhost:8081/creditcards/1/transactions/cost/Electronics
    http://localhost:8081/creditcards/1/transactions/cost/Groceries
8) Credit card limits customer wise
    http://localhost:8081/customer/limit
9) Credit card payment history along with the limits
    http://localhost:8081/creditcards/1/payments
10)     Average Time to approve or reject a card
    http://localhost:8081/cardapplications/averageresponsetime/reject
    http://localhost:8081/cardapplications/averageresponsetime/approve
11) Classification of customer based on the payment and spend history
a) Based on Payment
    http://localhost:8081/customer/payment/classification
b) Based on spending history
    http://localhost:8081/customer/transaction/classification
12) Credit card expiring in next 3 months
    http://localhost:8081/creditcards/expiry
13) Region wise usage of Credit card
    http://localhost:8081/creditcards/2/transactions/region
14) Region wise sale of credit card
    http://localhost:8081/cardapplications/regionalsales
15) Customer demographics
    http://localhost:8081/customer/demographics/maritalstatus
http://localhost:8081/customer/demographics/householdsize
    http://localhost:8081/customer/demographics/gender
16) No. of credit card discontinued customer wise with region and demographics and reasons
a) credit cards discontinued state wise
    http://localhost:8081/creditcards/discontinued/state
b) credit cards discontinued income wise
    http://localhost:8081/creditcards/discontinued/income
c) Credit card discontinued marital status wise
    http://localhost:8081/creditcards/discontinued/maritalstatus
d) Credit card discontinued customer name and reason
    http://localhost:8081/creditcards/discontinued/reason
