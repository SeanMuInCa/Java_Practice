package Lab4;

import java.util.Scanner;
/**
 * Purpose:             Determine the number of back-to-back repeated character that appears on an input line <br />
 * Data Submitted:      9/26/2023 <br />
 * Assignment Number:   Lab 4  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab4/Program4.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program4
{
    public static void main(String[] args)
    {
        //declare two variables for string and counter
        String sString;
        int nDupOccurances = 0;

        //Create a Scanner object for input
        Scanner myStringInput = new Scanner(System.in);

        // Prompt the user to enter
        System.out.print("Input a string: ");
        sString = myStringInput.nextLine();

        //test each letter of the string
        for (int i = 0; i < sString.length() - 1; i++)
        {
            if (sString.charAt(i) == sString.charAt(i + 1))
            {
                //find one back-to-back letter
                nDupOccurances++;
            }
        }
        //display the result
        System.out.println("There are " + nDupOccurances + " back-to-back repeated character appears in the line.");
    }
}
