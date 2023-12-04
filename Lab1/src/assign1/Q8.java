package assign1;

import java.util.Scanner;

/**
 * Purpose:             To calculate the day of the week using Zeller’s congruence. <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Assignment 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          assign1/Q8.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Q8
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter date
        System.out.print("Enter a Date (i.e.January 12 2000) : ");
        String month = input.next();
        int q = input.nextInt();
        int year = input.nextInt();
        int m;
        //assign the year and m based on user's input
        if (month.equals("January"))
        {
            year -= 1;//base on the formula the year minus one if jan or feb
            m = 13;//assign with 13 if jan
        } else if (month.equals("February"))
        {
            year -= 1;//base on the formula the year minus one if jan or feb
            m = 14;//assign with 14 if feb
        } else if (month.equals("March"))
        {
            m = 3;
        } else if (month.equals("April"))
        {
            m = 4;
        } else if (month.equals("May"))
        {
            m = 5;
        } else if (month.equals("June"))
        {
            m = 6;
        } else if (month.equals("July"))
        {
            m = 7;
        } else if (month.equals("August"))
        {
            m = 8;
        } else if (month.equals("September"))
        {
            m = 9;
        } else if (month.equals("October"))
        {
            m = 10;
        } else if (month.equals("November"))
        {
            m = 11;
        } else
        {
            m = 12;
        }
        int j = year / 100;
        int k = year % 100;

        //calculate the zeller's formula
        int h = (q + 26 * (m + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;


        // to display which day is based on the result
        if (h == 1)
        {
            System.out.println("Sunday" + "(" + h + ")");
        } else if (h == 2)
        {
            System.out.println("Monday" + "(" + h + ")");
        } else if (h == 3)
        {
            System.out.println("Tuesday" + "(" + h + ")");
        } else if (h == 4)
        {
            System.out.println("Wednesday" + "(" + h + ")");
        } else if (h == 5)
        {
            System.out.println("Thursday" + "(" + h + ")");
        } else if (h == 6)
        {
            System.out.println("Friday" + "(" + h + ")");
        } else if (h == 0)
        {
            System.out.println("Saturday" + "(" + h + ")");
        }

    }
}
