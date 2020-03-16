package com.example.CharterHomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;


@SpringBootApplication
public class CharterHomeworkApplication {

	public static void main(String[] args) {

		/*
			I need the dependencies associated with tomcat and web server applications for Spring Boot,
			But I do no need the web server application to stay running after my solution to the question.
			So I set the Web Application type to none.

		 */
		SpringApplication app = new SpringApplication(CharterHomeworkApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);



	}

	// Using CommandLineRunner since I think I can present my solution here easiest simply by displaying it in the console.
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("\nHomework from Charter Spectrum ");
			System.out.println("Solution by Byron Smith");

			// Wasn't sure exactly how you wanted this record of transactions and customers, so I just instantiated a data set.
			// And am going to put all of the instantiations into Array Lists which I can then loop through and do the correct
			// Calculations on.

			ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
			ArrayList<Transaction> transactionArrayList = new ArrayList<Transaction>();

			Customer customer1 = new Customer("Jane Doe");
			Customer customer2 = new Customer("John Smith");

			customerArrayList.add(customer1);
			customerArrayList.add(customer2);



			/*
			Again not knowing how you wanted this,  have to instantiate multiple transactions. Only went with two customers
			just so that I can show functionality. I know this looks a bit cumbersome, but I am going to put all
			transactions into an Array List and loop through them. Much like I am going to do with the Customers

			 */

			Transaction t1 = new Transaction(0,120.23, "2020-02-08");  // 90 points - Provided Example
			Transaction t2 = new Transaction(0,20.53, "2020-02-12");	// 	0 Points
			Transaction t3 = new Transaction(0,70.29, "2020-03-10");	// 20 Points
			Transaction t4 = new Transaction(0,102.27, "2020-03-14");	// 54 Points
			Transaction t5 = new Transaction(0,130.83, "2020-01-14");	// 110 Points
			Transaction t6 = new Transaction(0,12.23, "2020-01-02");	//  0 Points
			Transaction t7 = new Transaction(0,52.78, "2020-02-14");	// 2 Points
			Transaction t8 = new Transaction(0,167.50, "2020-02-21");	// 184 Points

			// Customer Zero should have 460 total points - 110 for Jan - 276 for Feb - 74 for March

			Transaction t9 = new Transaction(1,121.63, "2020-01-04");	//	92 Points
			Transaction t10 = new Transaction(1,57.14, "2020-01-18");	//	 7 Points
			Transaction t11 = new Transaction(1,111.23, "2020-02-25");	//	72 Points
			Transaction t12 = new Transaction(1,152.23, "2020-02-21");	//	154 Points
			Transaction t13 = new Transaction(1,10.11, "2020-02-28");	//	 0 Points
			Transaction t14 = new Transaction(1,69.54, "2020-03-03");	//	19 Points
			Transaction t15 = new Transaction(1,111.03, "2020-03-11");	//	72 Points
			Transaction t16 = new Transaction(1,200.12, "2020-03-14");	//	250 Points

			// Customer One should have 666 total points - 99 for Jan - 226 for Feb - 341 for March


			// Now to add all the transactions into the transaction list.

			Collections.addAll(transactionArrayList,t1,t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16);



			/*
			Loop through all of the transactions and the customers, and if the ID matches then add the
			appropriate number of points to their record. Could have also used a nested for each loops.
			 */

			for(int i = 0; i < transactionArrayList.size(); i++)
			{
				for(int j = 0; j < customerArrayList.size(); j++)
				{
					if(customerArrayList.get(j).getCustomerID() == transactionArrayList.get(i).getCustomerID())
					{
						customerArrayList.get(j).addRewardPoints(transactionArrayList.get(i));
					}
				}
			}

			int x = 0;
			LocalDate today;
			today = LocalDate.now();

			for(int i = 0; i < customerArrayList.size(); i++)
			{
				for(int j = 0; j < today.getMonthValue(); j++)
				{
					System.out.println("Customer " + (i+1) + " earned " + customerArrayList.get(i).getMonthPoints(j+1) + " points in month " + (j+1));
				}

				System.out.println("Customer " + (i+1) +  ": " + customerArrayList.get(i).getName() + " has accrued " + customerArrayList.get(i).getTotalPoints() + " Total Points");
				System.out.println();
			}


		};
	}
}