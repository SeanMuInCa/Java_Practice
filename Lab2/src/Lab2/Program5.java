package Lab2;

/**
 * Purpose:             Output the inputted text and move the first word to the end. <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Lab 2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab2/Program5.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
import java.util.Scanner;
public class Program5
{
    public static void main(String[] args)
    {
        String text, firstWord, remainder;
        int index;

        //create a Scanner
        Scanner myLineInput = new Scanner(System.in);

        //promote the user to input a string
        System.out.print("Enter a String text: ");
        text = myLineInput.nextLine();
        text = text.trim();

        //get the position of the 1st blank, first word and rest of the string
        index = text.indexOf(" ");
        firstWord = text.substring(0, index);
        remainder = text.substring(index);
        remainder = remainder.trim();

        //display with first word move to the end
        System.out.println(remainder+" "+firstWord);
    }
}
