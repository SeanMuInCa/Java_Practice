package assign1;

import java.util.Scanner;

/**
 * Purpose:             To calculate the Average acceleration <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Assignment 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          assign1/Q7.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Q7
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        //declare three variables  the starting velocity (v0), the ending velocity (v1) and time(t)
        float v0, v1, t;

        // Prompt the user to enter v and t
        System.out.print("Please enter v0, v1 and t: ");
        v0 = input.nextFloat();
        v1 = input.nextFloat();
        t = input.nextFloat();

        //calculate the Average acceleration
        float a = (v1 - v0) / t;

        //display the result
        System.out.println("The average acceleration is: " + a);
    }
}
