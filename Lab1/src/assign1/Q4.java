package assign1;

import java.util.Scanner;

/**
 * Purpose:             To calculate and displays the result based on the discriminant. <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Assignment 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          assign1/Q4.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Q4
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the variables for the formula
        float a, b, c;
        System.out.print("Enter a, b, c: ");
        a = input.nextFloat();
        b = input.nextFloat();
        c = input.nextFloat();

        // calculate the discriminant
        float discriminant = (float) Math.pow((b * b - 4 * a * c), 0.5);

        //if greater than 0 means two results
        if (discriminant > 0)
        {
            double result1, result2;
            result1 = (-b + discriminant) / 2 * a;
            result2 = (-b - discriminant) / 2 * a;
            System.out.println("The equation has two roots " + result1 + " and " + result2);
        } else if (discriminant == 0)//if 0, means one result
        {
            float result1 = (-b + discriminant) / 2 * a;
            System.out.println("The equation has one root " + result1);
        } else//if less than 0,means no real roots
        {
            System.out.println("The equation has no real roots");
        }
    }
}
