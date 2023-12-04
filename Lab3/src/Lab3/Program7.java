package Lab3;

import java.util.Scanner;
/**
 * Purpose:             To show the number and its absolute <br />
 * Data Submitted:      9/20/2023 <br />
 * Assignment Number:   Lab 3  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab3/Lab3/Program7.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program7
{
    public static void main(String[] args)
    {
        //declare two variables
        int inputValue, absValue;

        //Create a Scanner object for input
        Scanner myAbsInput = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Please input a number: ");
        inputValue = myAbsInput.nextInt();

        //calculate the number and its absolute
        absValue = inputValue > 0 ? inputValue : -inputValue;

        //display the result
        System.out.println("The number you entered is " + inputValue + " and its absolute is " + absValue);
    }
}
