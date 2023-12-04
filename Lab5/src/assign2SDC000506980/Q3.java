package assign2SDC000506980;

import java.util.Scanner;

/**
 * Purpose:             To read a Base 13 number convert it to its equivalent decimal representation <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   Assignment2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           assign2SDC000506980/Q3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Q3
{
    public static void main(String[] args)
    {

        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a Base 13 number up to 5 digits: ");
        String str = input.nextLine().toUpperCase();

        int dec = 0;

        for (int i = 0; i < str.length(); i++)
        {
            //to calculate each character equals decimal number
            dec += countBase13(str.charAt(i)) * Math.pow(13, str.length() - 1 - i);
        }
        System.out.print("The decimal number for " + str + " is " + dec);
    }

    /**
     * to count a base 13 number to a decimal number
     *
     * @param c char a base 13 number's character
     * @return int the base 13 character equals decimal number
     */
    public static int countBase13(char c)
    {
        return (c <= 'F' && c >= 'A') ? 10 + c - 'A' : c - '0';
    }

}
