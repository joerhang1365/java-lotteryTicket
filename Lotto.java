// Name: Joseph hanger
// Date Created: October 1, 2022
// Date Modified: October 3, 2022
// Description: This program takes input and creates a lucky lottery ticket
// for them. It also checks to see if there are duplicate numbers.

import java.lang.Math;
import java.util.Scanner;

public class Lotto {

    private static final int DEFAULT_MONTH = 6;
    private static final int DEFAULT_YEAR = 2000;
    private static final int DEFAULT_DAY = 15;
    private static final String DEFAULT_PHRASE = "All Izz Well!";

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        // Input **************************************************************
        int favMonth;
        int dayOfBirth;
        int highSchoolGradYear;
        int intAngle;
        String phrase;
        String randChar;

        // Output *************************************************************
        int[] lotteryTicketNums = { 0, 0, 0, 0, 0 };
        int powerball;

        // Introduction *******************************************************
        System.out.println("Welcome to the Lottery Number Generator. " +
                "\nThis program will decide what your lottery picks should be.");
        System.out.print("Press Enter...");
        stdin.nextLine();

        System.out.println("To begin generating your ticket, answer the " +
                "following questions.");
        System.out.print("Press Enter...");
        stdin.nextLine();

        // Favorite Month *****************************************************
        System.out.print("Question #1: What is the numerical value of your " +
                "favorite month 1-12? ");
        favMonth = stdin.nextInt();

        if (1 > favMonth || favMonth > 12) {
            System.out.println("Invalid input: Using defaults...");
            favMonth = DEFAULT_MONTH;
        }

        lotteryTicketNums[0] = (favMonth * 25) % 70 + 1;

        // Day Of Birth *******************************************************
        System.out.print("Question #2: What is the numerical value for the " +
                "day of your birth? ");
        dayOfBirth = stdin.nextInt();

        if (1 > dayOfBirth || dayOfBirth > 31) {
            System.out.println("Invalid input: Using defaults...");
            dayOfBirth = DEFAULT_DAY;
        }

        lotteryTicketNums[1] = (dayOfBirth * 3) % 70 + 1;

        // Year High School Graduation ****************************************
        System.out.print("Question #3: What is the year of your High School " +
                "graduation? ");
        highSchoolGradYear = stdin.nextInt();

        if (1900 > highSchoolGradYear) {
            System.out.println("Invalid input: Using defaults...");
            highSchoolGradYear = DEFAULT_YEAR;
        }

        lotteryTicketNums[2] = (highSchoolGradYear / 2 + 2) % 70 + 1;

        // Phrase/Motto To Live By ********************************************
        System.out.print("Question #4: What is a phrase/motto you live by? ");
        phrase = stdin.next();
        stdin.nextLine();

        if (phrase.length() == 0) {
            System.out.println("Invalid input: Using defaults...");
            phrase = DEFAULT_PHRASE;
        }

        lotteryTicketNums[3] = (int) (Math.log((phrase.length())) * 15) % 70 + 1;

        // Angle **************************************************************
        System.out.print("Question #5: What is an angle measurement in " +
                "degrees? ");
        intAngle = stdin.nextInt();

        lotteryTicketNums[4] = (int) (Math.abs(Math.sin(intAngle * Math.PI / 180)) * 70 + 1);

        // Random Key *********************************************************
        System.out.print("Question #6: Enter a random character on your " +
                "keyboard. ");
        randChar = stdin.next();
        stdin.nextLine();

        powerball = (int) (Math.sqrt(Math.pow(randChar.charAt(0), 5))) % 70 + 1;

        // Check For Duplicate Lottery Numbers ********************************
        for (int i = 0; i < 5; i++)
            if ((i > 0 && lotteryTicketNums[0] == lotteryTicketNums[i]) ||
                    ((1 > i || i > 1) && lotteryTicketNums[1] == lotteryTicketNums[i]) ||
                    ((2 > i || i > 2) && lotteryTicketNums[2] == lotteryTicketNums[i]) ||
                    ((3 > i || i > 3) && lotteryTicketNums[3] == lotteryTicketNums[i]) ||
                    ((4 > i || i > 4) && lotteryTicketNums[4] == lotteryTicketNums[i])) {
                System.out.println("An Error Has Been Found In Your Ticket " +
                        "Please Try Again." + "\nQutting Program...");
                System.exit(0);
            }

        // Print Lottery and PowerBall Values *********************************
        System.out.println("This is your prefered Lottery Ticket: " +
                lotteryTicketNums[0] + "-" + lotteryTicketNums[1] + "-" +
                lotteryTicketNums[2] + "-" + lotteryTicketNums[3] + "-" +
                lotteryTicketNums[4] + ", with PowerBall: " + powerball);
    }

}