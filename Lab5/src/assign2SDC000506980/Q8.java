package assign2SDC000506980;

import java.util.Scanner;

/**
 * Purpose:             To determining a given number is a palindrome prime <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   Assignment2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           assign2SDC000506980/Q8 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Q8
{
    public static void main(String[] args)
    {

        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        System.out.println("The number " + number + " is" + (isPallyPrime(number) ? " " : " not ") + "a palindrome prime");
    }

    /**
     * To determining a given number is a palindrome prime
     *
     * @param nVal int input number
     * @return boolean check the number true or false as a polindrome number
     */
    public static boolean isPallyPrime(long nVal)
    {
        if(!isPrime(nVal)) return false;
        String stringNumber = nVal + "";
        //left=start position from left, right is the last one
        int left = 0;
        int right = stringNumber.length() - 1;
        while (left < right)
        {
            if (stringNumber.charAt(left) != stringNumber.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     *
     * @param n long input number
     * @return true if the given number is a prime
     */
    public static boolean isPrime(long n){
        if (n <= 1) return false;
        for(int i = 2; i < n; ++i)
            if (n % i == 0) return false;
        return true;
    }
}
