package assign1;

import java.util.Scanner;

/**
 * Purpose:             To calculate compound interests of the investment <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Assignment 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          assign1/Q6.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Q6
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the amount of the money, years and rate
        System.out.print("Input the principal amount of investment: ");
        float principalAmount = input.nextFloat();
        System.out.print("Input the number of years: ");
        float years = input.nextFloat();
        System.out.print("Input the interest rate %: ");
        float rate = input.nextFloat();
        int frequenciesPerYear = 12;

        //calculate the compound interest using formula
        double compoundInterest = principalAmount * Math.pow((1 + rate / 100 / frequenciesPerYear), frequenciesPerYear * years * 12);

        //display the result
        System.out.println("Your investment is " + principalAmount + "$ in " + years + " years with " + rate + "% rates, you will get " + (int) (compoundInterest * 100) / 100.0 + "$");
    }
}
