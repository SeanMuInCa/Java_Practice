package Lab2;

import java.util.Scanner;

/**
 * Purpose:             Output the inputted value as different results using different Math methods. <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Lab 2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab2/Program3.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program3
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner myDoubleInput = new Scanner(System.in);

        // Prompt the user to enter first number and exp number
        System.out.print("Input 4 numbers: ");
        double val1, val2, val3, val4;
        val1 = myDoubleInput.nextDouble();
        val2 = myDoubleInput.nextDouble();
        val3 = myDoubleInput.nextDouble();
        val4 = myDoubleInput.nextDouble();

        //calculate and display the results
        System.out.println("<" + val1 + "> rounded up is " + Math.ceil(val1));
        System.out.println("<" + val1 + "> rounded down is " + Math.floor(val1));
        System.out.println("The min value of <" + val2 + "> and <" + val3 + "> is " + Math.min(val2, val3));
        System.out.println("The max value of <" + val2 + "> and <" + val3 + "> is " + Math.max(val2, val3));
        System.out.println("The absolute value of <" + val4 + "> is " + Math.abs(val4));
    }
}
