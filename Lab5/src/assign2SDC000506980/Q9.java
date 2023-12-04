package assign2SDC000506980;

import java.util.Scanner;

/**
 * Purpose:             To validate credit card numbers <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   Assignment2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           assign2SDC000506980/Q9 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Q9
{
    public static void main(String[] args)
    {

        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a credit card number as a long integer: ");
        long number = input.nextLong();
        if ((prefixCorrect(number, 4) || prefixCorrect(number, 5) || prefixCorrect(number, 6) || prefixCorrect(number, 37)) && (getSize(number) >= 13 && getSize(number) <= 16))
        {
            System.out.println(number + " is" + (isValid(number) ? " valid" : " invalid"));
        } else
        {
            System.out.println(number + " is invalid");
        }

    }

    /**
     * Return true if the card number is valid
     */
    public static boolean isValid(long number)
    {
        return (sumOfDoubleEvenPlaces(number) + sumOfOddPlaces(number)) % 10 == 0;
    }

    /**
     * Get the result from Step 2
     */
    public static int sumOfDoubleEvenPlaces(long number)
    {
        int sum = 0;
        while (number > 10)
        {
            int evenDigit = (int) ((number / 10) % 10);
            sum += getSumDigits(evenDigit * 2);
            number = number / 100;
        }
        return sum;
    }

    /**
     * Return number if it is a single digit, otherwise,
     * return the sum of the two digits(from step 1)
     */
    public static int getSumDigits(int number)
    {
        return number > 9 ? number % 10 + (number / 10) % 10 : number;
    }

    /**
     * Return sum of odd-place digits in number (step 3)
     */
    public static int sumOfOddPlaces(long number)
    {
        int sum = 0;
        while (number > 10)
        {
            int evenDigit = (int) (number % 10);
            sum += getSumDigits(evenDigit);
            number = number / 100;
        }
        return sum;
    }

    /**
     * Return true if number has a proper prefix
     */
    public static boolean prefixCorrect(long number, int d)
    {
        String numberAsString = number + "";
        int length = numberAsString.length();
        if (d < 10) return number / (d * (long) Math.pow(10, length - 1)) == 1;
        else return number / (d * (long) Math.pow(10, length - 2)) == 1;
    }

    /**
     * Return the number of digits in d
     */

    public static int getSize(long d)
    {
        String numberAsString = d + "";
        return numberAsString.trim().length();
    }
}
