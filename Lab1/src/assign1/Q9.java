package assign1;

import java.util.Scanner;

/**
 * Purpose:             To calculate the fine that is to be paid if you return the item back late.<br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Assignment 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          assign1/Q9.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Q9
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the item type
        System.out.print("Please enter your item type (i.e.Regular item or Reserved item or Special item): ");
        String itemType = input.nextLine();
        float finePerDay = 0;

        //assign the fine per day based on user's input
        if (itemType.equals("Regular item"))
        {
            finePerDay = 0.5F;
        } else if (itemType.equals("Reserved item"))
        {
            finePerDay = 1;
        } else if (itemType.equals("Special item"))
        {
            finePerDay = 2;
        }

        // Prompt the user to enter the amount of day
        System.out.print("Please enter number of days late: ");
        int days = input.nextInt();

        //calculate the fee
        float totalFee = finePerDay * days;
        if (totalFee > 10)
        {
            totalFee = 10;//the fee has a limit based on the rule
        }
        System.out.println("Item type is: " + itemType + ", the fine per day late is " + finePerDay + "$, "
                + "and for " + days + " days late, the total fee is " + totalFee + "$.");
    }
}
