package Lab3;

import java.util.Scanner;
/**
 * Purpose:             To see if the user's name's begin letter and the last letter are the same  <br />
 * Data Submitted:      9/20/2023 <br />
 * Assignment Number:   Lab 3  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab3/Lab3/Program3.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program3
{
    public static void main(String[] args)
    {
        //declare a variable for input
        String name;

        //Create a Scanner object for input
        Scanner myNameInput = new Scanner(System.in);

        //Prompt the user to enter name
        System.out.print("Enter your name: ");
        name = myNameInput.nextLine().toLowerCase();

        //to see if the user's name with the same letter at start and last
        if (name.charAt(0) == name.charAt(name.length() - 1))
        {
            System.out.println("Your name starts and ends with the same letter!");
        } else
        {
            System.out.println("You have a nice name.");
        }
    }
}
