package Lab4;

import java.util.Scanner;
/**
 * Purpose:             Count how many times a char occurs in the line <br />
 * Data Submitted:      9/26/2023 <br />
 * Assignment Number:   Lab 4  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab4/Program5.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program5
{
    public static void main(String[] args)
    {
        //declare three variables for string char and counter
        String sLine;
        char sChar;
        int nCount = 0;

        //Create a Scanner object for input
        Scanner myStringInput = new Scanner(System.in);

        // Prompt the user to enter
        System.out.print("Input a string: ");
        sLine = myStringInput.nextLine();
        System.out.print("Input a char: ");
        sChar = myStringInput.nextLine().charAt(0);

        //create a loop the test each character of the string
        for (int i = 0; i < sLine.length(); i++)
        {
            if (sChar == sLine.charAt(i))
            {
                //count + 1 if found a match
                nCount++;
            }
        }
        //display the result
        System.out.println("The character " + sChar + " occurs " + nCount + " times in the line " + "\"" + sLine + "\"");
    }
}
