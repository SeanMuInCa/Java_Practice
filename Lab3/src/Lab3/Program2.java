package Lab3;

import java.util.Scanner;

/**
 * Purpose:             To display the type of people based on their age  <br />
 * Data Submitted:      9/20/2023 <br />
 * Assignment Number:   Lab 3  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab3/Lab3/Program2.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program2
{
    public static void main(String[] args)
    {
        //declare variable for age
        int age;

        //Create a Scanner object for input
        Scanner myAgeInput = new Scanner(System.in);

        // Prompt the user to enter age
        System.out.print("Input your age: ");
        age = myAgeInput.nextInt();

        //calculate the age and display the type
        if (age < 0 || age > 120)
        {
            System.out.println("The age must be between 0 and 120!");
        } else if (age < 13)
        {
            System.out.println("child!");
        } else if (age <= 17)
        {
            System.out.println("teenager!");
        } else if (age <= 65)
        {
            System.out.println("adult!");
        } else
        {
            System.out.println("senior!");
        }
    }
}
