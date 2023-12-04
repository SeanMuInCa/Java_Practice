package Lab2;

/**
 * Purpose:             Determine whether the second line is found within the first line. <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Lab 2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab2/Program4.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
import java.util.Scanner;

public class Program4
{
    public static void main(String[] args)
    {
        String line1, line2;
        int index;

        //Create a Scanner object for input
        Scanner myStringInput = new Scanner(System.in);

        // Prompt the user to enter first number and exp number
        System.out.print("Enter the first line of text: ");
        line1 = myStringInput.nextLine().trim();
        System.out.print("Enter another line of text: ");
        line2 = myStringInput.nextLine().trim();

        //to see if line2 is inside line1
        index = line1.indexOf(line2);

        //different display based on index
        if (index == -1)
        {
            System.out.println("The 2nd line you've input \"" + line2 + "\" does not included in your 1st line \"" + line1 + "\"");
        } else
        {
            System.out.println("The 2nd line you've input \"" + line2 + "\" is found in your 1st line \"" + line1 + "\" in position " + (index + 1));
        }
    }
}
