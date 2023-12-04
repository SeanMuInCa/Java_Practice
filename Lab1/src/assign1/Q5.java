package assign1;

import java.util.Scanner;

/**
 * Purpose:             To calculate sums up all the digits from a five-digits number. <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Assignment 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          assign1/Q5.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */

public class Q5
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        //declare variables
        // one for the sum
        // one for the rest
        // as 10 5th power, because the number is five digits
        int sum = 0;
        int rest = 0;
        int digits = 10000;

        // Prompt the user to enter prices and tip
        System.out.print("Enter a five-digit number: ");
        int inputData = input.nextInt();

        //calculate the sum and rest
        sum = inputData / digits;
        rest = inputData % digits;


        // use a loop to do rest 4 times
        for (int i = 0; i < 4; i++)
        {
            digits /= 10;
            sum += rest / digits;
            rest = rest % digits;
        }

        //display the result
        System.out.println(sum);
    }
}
