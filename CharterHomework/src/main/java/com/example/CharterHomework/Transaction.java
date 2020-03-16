package com.example.CharterHomework;

import java.time.LocalDate;


public class Transaction {

    // Static counter to work like an auto incrementing variable so that each transaction can have a unique identifyer
    private static int numTransactions;
    private int transactionNumber;
    private int customerID;
    private double amount;
    private LocalDate date;

    // Constructor which will accept a customer number, total, and date for the transaction as a string
    // Parse that date string using LocalDate built in parsing method to create the date object
    public Transaction(int customerID, double amount, String date) {
        this.customerID = customerID;
        this.amount = amount;
        this.date = LocalDate.parse(date);
        transactionNumber = numTransactions;
        numTransactions++;
    }


    // Constructor without when a date is not provided will use the current date for the transaction.
    public Transaction(int customerID, double amount) {
        this.customerID = customerID;
        this.amount = amount;
        date =  LocalDate.now();
        transactionNumber = numTransactions;
        numTransactions++;
    }

    // Basic getter methods to keep data encapsulated.
    public LocalDate getDate() {
        return date;
    }

    public int getCustomerID() {
        return customerID;
    }

    public double getAmount() {
        return amount;
    }

}
