package assign2SDC000506980;

import java.util.Scanner;

/**
 * Purpose:             To read a string and display its corresponding telephone digit sequence <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   Assignment2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           assign2SDC000506980/Q1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Q1
{
    public static void main(String[] args)
    {

        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String str = input.nextLine().toUpperCase();
        String result = "";

        for (int i = 0; i < str.length(); i++)
        {
            //loop the string and map each character to number and result them together
            result += mapToNumbers(str.charAt(i));
        }
        System.out.println("Phone #sequence: " + result);
    }

    /**
     * to map the character to number
     *
     * @param character char input character
     * @return char the number map to the character
     */
    private static char mapToNumbers(char character)
    {
        char result = 0;
        switch (character)
        {
            //determine result based on letters
            case 'A', 'B', 'C' -> result = '2';
            case 'D', 'E', 'F' -> result = '3';
            case 'G', 'H', 'I' -> result = '4';
            case 'J', 'K', 'L' -> result = '5';
            case 'M', 'N', 'O' -> result = '6';
            case 'P', 'Q', 'R', 'S' -> result = '7';
            case 'T', 'U', 'V' -> result = '8';
            case 'X', 'Y', 'Z' -> result = '9';
            case ' ' -> result = '1';
        }
        return result;
    }
}
