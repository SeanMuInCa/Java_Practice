package Lab3;

import java.util.Scanner;
/**
 * Purpose:             To calculate the final cost  <br />
 * Data Submitted:      9/20/2023 <br />
 * Assignment Number:   Lab 3  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab3/Lab3/Program1.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program1
{
    public static void main(String[] args)
    {
        //declare three variables
        float itemCost, finalCost;
        boolean taxCode;
        //Create a Scanner object for input
        Scanner myCostInput = new Scanner(System.in);

        // Prompt the user to enter cost and tax
        System.out.print("Enter the cost of the item: ");
        itemCost = myCostInput.nextFloat();
        System.out.print("Enter the tax code (true/false):  ");
        taxCode = myCostInput.nextBoolean();

        //calculate the final price, and oh there is a trap
        finalCost = taxCode ? (float) ((int)((itemCost * 1.05)*100))/100 : itemCost;

        //display the result
        System.out.println("Your final cost is: " + finalCost);
    }
}
