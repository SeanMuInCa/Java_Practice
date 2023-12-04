package assign1;

import java.util.Scanner;

/**
 * Purpose:             To format the time data from milliseconds to GMT format  <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Assignment 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          assign1/Q3.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Q3
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        //declare three byte type variables
        byte hour, minute, second;

        // Prompt the user to enter milliseconds
        System.out.print("Enter your time in milliseconds: ");
        long time = input.nextLong();

        //calculate the hour minute and second
        hour = (byte) (time / 1000 / 60 / 60 % 24);
        minute = (byte) (time / 1000 / 60 % 60);
        second = (byte) (time / 1000 % 60);

        //display the result
        System.out.println("The time of " + time + " milliseconds since the Unix epoch is " + hour + ":" + minute + ":" + second + " GMT");
    }
}
