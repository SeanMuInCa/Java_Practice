package Lab3;

import java.util.Scanner;
/**
 * Purpose:             To show user about daily special  <br />
 * Data Submitted:      9/20/2023 <br />
 * Assignment Number:   Lab 3  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab3/Lab3/Program5.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program5
{
    //declare 14 const variables
    public static final String MONDAY_SPECIAL = "Lasagna";
    public static final String TUESDAY_SPECIAL = "Fish and chips";
    public static final String WEDNESDAY_SPECIAL = "Meat loaf";
    public static final String THURSDAY_SPECIAL = "Beef dip";
    public static final String FRIDAY_SPECIAL = "Chicken strips";
    public static final String SATURDAY_SPECIAL = "Dry ribs";
    public static final String SUNDAY_SPECIAL = "Turkey";

    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;
    public static final int SUNDAY = 7;

    public static void main(String[] args)
    {
        //declare a variable for user's input
        int dayNumber;

        //Create a Scanner object for input
        Scanner myDayNumInput = new Scanner(System.in);

        // Prompt the user to enter which day
        System.out.println("Enter a day code as follows:" + "\n" +
                "Monday = " + MONDAY + "\n" +
                "Tuesday = " + TUESDAY + "\n" +
                "Wednesday = " + WEDNESDAY + "\n" +
                "Thursday = " + THURSDAY + "\n" +
                "Friday = " + FRIDAY + "\n" +
                "Saturday = " + SATURDAY + "\n" +
                "Sunday = " + SUNDAY + "\n" +
                "What is today's day code (1-7)? ");

        dayNumber = myDayNumInput.nextInt();

        //display the daily special based on user's inputs
        switch (dayNumber)
        {
            case 1:
                System.out.println("Our daily special is " + MONDAY_SPECIAL);
                break;
            case 2:
                System.out.println("Our daily special is " + TUESDAY_SPECIAL);
                break;
            case 3:
                System.out.println("Our daily special is " + WEDNESDAY_SPECIAL);
                break;
            case 4:
                System.out.println("Our daily special is " + THURSDAY_SPECIAL);
                break;
            case 5:
                System.out.println("Our daily special is " + FRIDAY_SPECIAL);
                break;
            case 6:
                System.out.println("Our daily special is " + SATURDAY_SPECIAL);
                break;
            case 7:
                System.out.println("Our daily special is " + SUNDAY_SPECIAL);
                break;
            default:
                System.out.println("You entered an invalid day code!");

        }
    }
}
