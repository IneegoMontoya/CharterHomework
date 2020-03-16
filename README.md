# CharterHomework
Assignment given by Charter Spectrum

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

 

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

 

Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

Solution completed in Spring Boot.
Included dependencies: Spring Web
Build Tools: Maven

Though this solution uses the Spring Web dependency it is a Console program by use of Console Runner, with the webApplicationType set to NONE. This is because there was no need to continue to run the web services upon completion of the assigned task.  

To run project after cloning, inside project run command ./mvnw spring-boot:run 


Data set used for transactions of each of the two test customer is as follows 
  $120.23 2020-02-08    90 Points - Provided Example
	$20.53, 2020-02-12 	   0 Points
	$70.29, 2020-03-10	  20 Points
	$102.27,2020-03-14    54 Points
	$130.83, 2020-01-14  110 Points
	$12.23, 2020-01-02     0 Points
	$52.78, 2020-02-14     2 Points
	$167.50, 2020-02-21  184 Points

Customer Zero should have 460 total points - 110 for Jan - 276 for Feb - 74 for March

  $121.63 2020-01-04     92 Points 
	$57.14, 2020-01-18 	    7 Points
	$111.29, 2020-02-25	   72 Points
	$152.23,2020-02-21    154 Points
	$10.11, 2020-02-28      0 Points
	$69.54, 2020-03-03     19 Points
	$111.03, 2020-03-11    72 Points
	$200.12, 2020-03-14   250 Points

Customer One should have 666 total points - 99 for Jan - 226 for Feb - 341 for March


