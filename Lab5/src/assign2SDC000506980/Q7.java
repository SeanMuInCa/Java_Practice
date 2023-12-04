package assign2SDC000506980;

import java.util.Scanner;

/**
 * Purpose:             To draw a square of asterisks <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   Assignment2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           assign2SDC000506980/Q7 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Q7
{
    public static void main(String[] args)
    {

        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        int number;
        do
        {
            System.out.print("Enter a positive integer: ");
            number = input.nextInt();
        }while (number <= 0);

        drawAsterisksSquare(number);

    }

    public static void drawAsterisksSquare(int number)
    {
        for (int i = 0; i < number; i++)
        {
            for (int j = 0; j < number; j++)
            {
                if (i == j || i == number - j - 1 || i * j == 0 || (number - i - 1) * j == 0 || (number - j - 1) * i == 0)
                {
                    System.out.print("* ");
                } else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
