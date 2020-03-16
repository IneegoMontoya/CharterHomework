package com.example.CharterHomework;

import java.lang.reflect.Array;
import java.time.LocalDate;

public class Customer {


    private static int customerCount = 0;
    private int customerID;
    private String name;
    private int totalPoints;

    private int[] monthPoints;
    private int levelOneReward = 50;
    private int levelTwoReward = 100;

    public Customer(String name) {
        this.name = name;
        totalPoints = 0;
        monthPoints = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        customerID = customerCount;
        customerCount++;
    }

    /*
        Not sure how you would like to handle points accrued after three months have expired. Whether or not you
        would want them to roll over, or to only be calculated based upon the last three months.
        So going to base it off of only using the last three months. the get method will find out the current month and
        only award points for those most recent ones. Leaving out the logic for calendar roll over at this time.

        I have only implemented transactions for the first three months of the year.
     */
    public int getTotalPoints() {


        totalPoints = 0; // Just setting this to zero for the moment since not clear as to final calculations if you wanted to use the whole year.
        LocalDate currentDate;
        currentDate = LocalDate.now();
        int index = currentDate.getMonthValue();
        for(int i = 0; i < index; i++){
            totalPoints += monthPoints[i];
        }

        return totalPoints;
    }

    public int getMonthPoints(int x) {
        if(12 < x || 1 > x)
        {
            return 0;
        }
        return monthPoints[x-1];
    }

    public int getCustomerID() {
        return customerID;
    }

    public void addRewardPoints(Transaction t){
        int month = t.getDate().getMonthValue();
        int points = 0;
        int spent = (int)t.getAmount();

        if(levelTwoReward < spent)
        {
            points += levelOneReward;
            points += (spent - levelTwoReward)*2;
        }
        else if (levelOneReward < spent)
        {
            points += spent - levelOneReward;
        }

        monthPoints[month-1] += points;

    }

    public String getName() {
        return name;
    }


}