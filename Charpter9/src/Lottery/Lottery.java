package Lottery;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Purpose:             Lottery<br />
 * Data Submitted:      2023/12/4 <br />
 * Assignment Number:    Lottery<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lottery <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Lottery
{
    public static void main(String[] args)
    {
        int choice;
        int[] redBalls = new int[6];
        int blue = 0;
        int[] resultRed = new int[6];
        int resultBlue;
        do
        {
            printTitle();
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            if (choice == 1)
            {
                System.out.println("Welcome! You need to make a choice of 6 red balls and 1 blue ball!");
                redBalls = buyRedBalls();
                System.out.println(Arrays.toString(redBalls));
                blue = buyBlueBalls();
                System.out.println(blue);
            } else if (choice == 3)
            {
//                resultRed = new int[]{12, 13, 14, 15, 16, 17};
//                resultBlue= 2;
                resultRed = generateResult();
                resultBlue = getRandomNumber(1, 16);
//                System.out.println(Arrays.toString(resultRed));
//                System.out.println(resultBlue);
                System.out.println(checkWin(redBalls, resultRed, blue, resultBlue));
            } else if (choice == 2)
            {
                redBalls = generateResult();
                blue = getRandomNumber(1, 16);
                System.out.println("Your random red balls are: ");
                System.out.print(Arrays.toString(redBalls));
                System.out.println();
                System.out.println("Your random blue ball is: ");
                System.out.println(blue);
            }
        } while (choice != 4);
    }

    private static int[] generateResult()
    {
        int[] result = new int[6];
        for (int i = 0; i < 6; i++)
        {
            int number = getRandomNumber(1, 33);
            if (isValid(result, number))
            {
                result[i] = number;
            } else
            {
                i--;
            }
        }
        return result;
    }

    private static int buyBlueBalls()
    {
        System.out.println("Please choose your Blue ball!");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }

    private static int[] buyRedBalls()
    {
        int[] numbers = new int[6];
        for (int i = 0; i < 6; i++)
        {
            System.out.println("Please choose your " + (i + 1) + " Red ball!");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            if ((number > 0 && number < 34) && isValid(numbers, number))
            {
                numbers[i] = number;
            } else
            {
                System.out.println("Invalid input.Must be a number between 1 and 33. And can't repeat!");
                i--;
            }
        }
        return numbers;
    }

    public static boolean isValid(int[] arr, int num)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == num)
                return false;
        }
        return true;
    }

    private static void printTitle()
    {
        System.out.println("Welcome to D-Color Lottery Game!");
        System.out.println("\t1. Buy your tickets!");
        System.out.println("\t2. Buy random tickets!");
        System.out.println("\t2. Check the result!");
        System.out.println("\t3. See you next time!");
        System.out.print("Input your choice: ");
    }

    public static String checkWin(int[] users, int[] result, int userBlue, int resultBlue)
    {
        int count = 0;
        for (int i = 0; i < users.length; i++)
        {
            for (int j = 0; j < result.length; j++)
            {
                if (users[i] == result[j]) count++;
            }
        }
        System.out.println("You got " + count + " red ball equal!");
        System.out.println("Your blue ball is " + ((userBlue == resultBlue) ? "equal" : "not equal"));
        if ((count > 4) && (userBlue == resultBlue))
            return "You Win!!!! $1000";
        else if ((count > 3) && (userBlue == resultBlue))
            return "You Win!!!! $100";
        else if (userBlue == resultBlue)
        {
            return "You Win!!!! $10";
        }
        return "Maybe next time man!";
    }

    private static int getRandomNumber(int max, int min)
    {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
