package Lab4;

import java.util.Scanner;
/**
 * Purpose:             Convert an inputted number from decimal to hex <br />
 * Data Submitted:      9/26/2023 <br />
 * Assignment Number:   Lab 4  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab4/Program2.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program2
{
    public static void main(String[] args)
    {
        //declare two variables
        int decimal;
        String hexVal = "";

        //Create a Scanner object for input
        Scanner myDecInput = new Scanner(System.in);

        // Prompt the user to enter
        System.out.print("Input a number: ");
        decimal = myDecInput.nextInt();

        //as long as the decimal/16 not equal 0, that means still greater than 16
        while (decimal != 0)
        {
            int hexValue = decimal % 16;
            //if 0-9 the char is itself, if 10-15 then turn it to A-F
            char hexDigit = (char) (hexValue <= 9 && hexValue >= 0 ? hexValue + '0' : hexValue - 10 + 'A');
            //assign the hexVal with the correct order
            hexVal = hexDigit + hexVal;
            decimal /= 16;
        }
        //display the result
        System.out.println("The number you input in Hex is: " + hexVal);
    }
}
