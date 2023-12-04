package assign1;

import java.util.Scanner;

/**
 * Purpose:             To calculate the tips and total cost for a meal <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Assignment 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          assign1/Q2.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Q2
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter prices and tip
        System.out.print("Please enter Meal cost: ");
        float mealPrice = input.nextFloat();
        System.out.print("Please enter the Tip Percentage (i.e. 10 for 10%): ");
        float tip = input.nextFloat();

        //calculate the tips and total price
        float tipTotal = mealPrice * tip / 100;
        float priceTotal = mealPrice + tipTotal;

        // convert the result in an explicit way to 2 decimal
        tipTotal = (float) ((int) (tipTotal * 100)) / 100;
        priceTotal = (float) ((int) (priceTotal * 100)) / 100;

        //display the result
        System.out.println("Tip total is $" + tipTotal + " " + "Total Cost is $" + priceTotal);
    }
}
