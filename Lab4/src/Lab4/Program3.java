package Lab4;

import java.util.Scanner;
/**
 * Purpose:             Compute the greatest common divisor of two numbers <br />
 * Data Submitted:      9/26/2023 <br />
 * Assignment Number:   Lab 4  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab4/Program3.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program3
{
    public static void main(String[] args)
    {
        //declare three variables for two numbers and the gcd
        int n1, n2, gcd = 1;

        //Create a Scanner object for input
        Scanner myNumInput = new Scanner(System.in);

        // Prompt the user to enter
        System.out.print("Input two numbers: ");
        n1 = myNumInput.nextInt();
        n2 = myNumInput.nextInt();
        //1 is always gcd so start from 2
        int k = 2;

        //while k less than both n1 and n2
        while (k <= n1 && k <= n2)
        {
            //to see n1 and n2 are both divisible by k
            if (n1 % k == 0 && n2 % k == 0)
            {
                //if divisible, assign gcd with k
                gcd = k;
            }
            //check next number
            k++;
        }
        //display the result
        System.out.println("The greatest common divisor of your input numbers is: " + gcd);
    }
}
