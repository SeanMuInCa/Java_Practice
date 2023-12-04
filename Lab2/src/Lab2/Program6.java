package Lab2;
/**
 * Purpose:             Output the 2nd last word in a line <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Lab 2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab2/Program6.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
import java.util.Scanner;
public class Program6
{
    public static void main(String[] args){

        //create a Scanner
        Scanner stringInput = new Scanner(System.in);

        int wordSeparator;

        //promote the user to input a string
        System.out.print("Enter a string: ");
        String line = stringInput.nextLine().trim();

        //find the last blank
        wordSeparator = line.lastIndexOf(" ");
        //remove the last word and find the last blank again
        line = line.substring(0,wordSeparator);
        wordSeparator = line.lastIndexOf(" ");

        //find the 2nd last word
        String word2 = line.substring(wordSeparator + 1);

        //display the 2nd last word
        System.out.println("<<"+word2+">> is the second last word in the line.");

    }
}
