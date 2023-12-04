package Lab3;

import java.util.Scanner;
/**
 * Purpose:             To show user about daily special  <br />
 * Data Submitted:      9/20/2023 <br />
 * Assignment Number:   Lab 3  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab3/Lab3/Program4.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program4
{
    //declare 7 const variables
    public static final String MONDAY_SPECIAL = "Lasagna";
    public static final String TUESDAY_SPECIAL = "Fish and chips";
    public static final String WEDNESDAY_SPECIAL = "Meat loaf";
    public static final String THURSDAY_SPECIAL = "Beef dip";
    public static final String FRIDAY_SPECIAL = "Chicken strips";
    public static final String SATURDAY_SPECIAL = "Dry ribs";
    public static final String SUNDAY_SPECIAL = "Turkey";

    public static void main(String[] args)
    {
        //declare a variable for day
        String day;

        //Create a Scanner object for input
        Scanner myDayInput = new Scanner(System.in);

        // Prompt the user to enter day
        System.out.print("Input which day is today to check our special offer: ");
        day = myDayInput.next().toUpperCase();

        //display the result based on user's input
        if (day.equals("MONDAY"))
        {
            System.out.println("Our daily special is " + MONDAY_SPECIAL);
        } else if (day.equals("TUESDAY"))
        {
            System.out.println("Our daily special is " + TUESDAY_SPECIAL);
        } else if (day.equals("WEDNESDAY"))
        {
            System.out.println("Our daily special is " + WEDNESDAY_SPECIAL);
        } else if (day.equals("THURSDAY"))
        {
            System.out.println("Our daily special is " + THURSDAY_SPECIAL);
        } else if (day.equals("FRIDAY"))
        {
            System.out.println("Our daily special is " + FRIDAY_SPECIAL);
        } else if (day.equals("SATURDAY"))
        {
            System.out.println("Our daily special is " + SATURDAY_SPECIAL);
        } else if (day.equals("SUNDAY"))
        {
            System.out.println("Our daily special is " + SUNDAY_SPECIAL);
        } else
        {
            System.out.println("You entered an invalid day code!");
        }
    }
}
