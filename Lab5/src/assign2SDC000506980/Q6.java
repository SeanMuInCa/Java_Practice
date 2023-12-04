package assign2SDC000506980;

import java.util.Scanner;

/**
 * Purpose:             To report the number of each of the vowels in string <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   Assignment2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           assign2SDC000506980/Q6 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Q6
{
    public static void main(String[] args)
    {

        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Please enter a line of input to analyzed: ");
        String str = input.nextLine().toLowerCase();
        //declare variables for each vowel
        int aAppears = 0, eAppears = 0, iAppears = 0, oAppears = 0, uAppears = 0, yAppears = 0;
        for (int i = 0; i < str.length(); i++)
        {
            //loop the string and map each character to number
            switch (str.charAt(i))
            {
                case 'a' -> aAppears++;
                case 'e' -> eAppears++;
                case 'i' -> iAppears++;
                case 'o' -> oAppears++;
                case 'u' -> uAppears++;
                case 'y' -> yAppears++;
            }
        }
        System.out.println("Vowel count:");
        System.out.println("a\t" + aAppears);
        System.out.println("e\t" + eAppears);
        System.out.println("i\t" + iAppears);
        System.out.println("o\t" + oAppears);
        System.out.println("u\t" + uAppears);
        System.out.println("y\t" + yAppears);
    }
}
