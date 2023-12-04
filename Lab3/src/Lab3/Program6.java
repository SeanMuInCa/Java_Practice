package Lab3;

import java.util.Scanner;
/**
 * Purpose:             To show user ticket price based on different seat  <br />
 * Data Submitted:      9/20/2023 <br />
 * Assignment Number:   Lab 3  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab3/Lab3/Program6.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program6
{
    //Character codes for seating levels
    public static final char FIELD = 'f';
    public static final char MEZZANINE = 'm';
    public static final char UPPER = 'u';
    //Character codes for opponent categories
    public static final char PLATINUM = 'p';
    public static final char GOLD = 'g';
    public static final char SILVER = 's';
    public static final char BRONZE = 'b';

    public static void main(String[] args)
    {
        //declare three variables
        char seatingLevel, oppCategory;
        int ticketPrice;

        ///Create a Scanner object for input
        Scanner myGameInput = new Scanner(System.in);

        //Prompt the user to enter seat level and opponent category
        System.out.println("Enter your seating level: (FIELD MEZZANINE UPPER)");
        seatingLevel = myGameInput.nextLine().toLowerCase().charAt(0);
        if (seatingLevel != 'f' && seatingLevel != 'm' && seatingLevel != 'u')
        {
            System.out.println("Your input is invalidates, we put your seat level in UPPER level");
            seatingLevel = 'u';
        }
        System.out.println("Enter the opponent category: (PLATINUM GOLD SILVER BRONZE )");
        oppCategory = myGameInput.nextLine().toLowerCase().charAt(0);
        if (oppCategory != 'p' && oppCategory != 'g' && oppCategory != 's' && oppCategory != 'b')
        {
            System.out.println("Your input is invalidates, we think you may need BRONZE");
            oppCategory = 'b';
        }

        //calculate the price and display
        if (seatingLevel == 'f')
        {
            if (oppCategory == 'p')
            {
                ticketPrice = 77;
            } else if (oppCategory == 'g')
            {
                ticketPrice = 67;
            } else if (oppCategory == 's')
            {
                ticketPrice = 62;
            } else
            {
                ticketPrice = 57;
            }

        } else if (seatingLevel == 'm')
        {
            if (oppCategory == 'p')
            {
                ticketPrice = 54;
            } else if (oppCategory == 'g')
            {
                ticketPrice = 48;
            } else if (oppCategory == 's')
            {
                ticketPrice = 45;
            } else
            {
                ticketPrice = 42;
            }
        } else
        {
            if (oppCategory == 'p')
            {
                ticketPrice = 35;
            } else if (oppCategory == 'g')
            {
                ticketPrice = 31;
            } else if (oppCategory == 's')
            {
                ticketPrice = 29;
            } else
            {
                ticketPrice = 27;
            }
        }
        System.out.println("Your ticket price is: " + ticketPrice);
    }
}
