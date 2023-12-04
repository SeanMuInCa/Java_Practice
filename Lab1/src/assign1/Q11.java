package assign1;

import java.util.Scanner;

/**
 * Purpose:             to see if a point is inside or outside a triangle <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Assignment 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          assign1/Q11.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Q11
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter x and y coordinates
        System.out.print("Enter a point's x- and y-coordinates: ");
        int x = input.nextInt();
        int y = input.nextInt();

        // x is inside based on the triangle sample
        if (x >= 0 && x <= 200)
        {
            //y is inside based on the triangle sample. y is calculated by math
            if (y <= 100 * (200 - x) / 200 && y >= 0)
            {
                System.out.println("The point is in the triangle");
            } else
            {
                System.out.println("The point is not in the triangle");
            }
        } else
        {
            System.out.println("The point is not in the triangle");
        }
    }
}
