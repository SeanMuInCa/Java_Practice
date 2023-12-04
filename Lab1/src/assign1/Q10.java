package assign1;

import java.util.Scanner;

/**
 * Purpose:             to play a game with computer <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Assignment 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          assign1/Q10.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Q10
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        //get a random number from 1 to 5, to store what is computer's play
        int max = 5;
        int min = 1;
        int computerPlays = min + (int) (Math.random() * (max - min + 1));

        // Prompt the user to enter user's play
        System.out.print("Rock(1), Paper (2), Scissors(3) , Lizard (4), Spock (5): Guess? ");
        int playerPlays = input.nextInt();

        //who is going to win
        if (playerPlays == 1)// user is Rock
        {
            if (computerPlays == 2)//Paper
            {
                System.out.println("The computer is Paper. LOSE: Paper Covers Rock!");
            } else if (computerPlays == 3)//Scissor
            {
                System.out.println("The computer is scissors. WIN: Rock Crushes Scissors!");
            } else if (computerPlays == 4)//lizard
            {
                System.out.println("The computer is lizard. WIN: Rock Crushes lizard!");
            } else if (computerPlays == 5)//spock
            {
                System.out.println("The computer is Spock. LOSE: Spock vaporizes Rock!");
            } else
            {
                System.out.println("The computer is Rock too. It's a tie!");
            }
        } else if (playerPlays == 2)//user is Paper
        {

            if (computerPlays == 1)//Rock
            {
                System.out.println("The computer is Rock. WIN: Paper Covers Rock!");
            } else if (computerPlays == 3)//Scissor
            {
                System.out.println("The computer is scissors. LOSE: Scissors Cut Paper!");
            } else if (computerPlays == 4)//lizard
            {
                System.out.println("The computer is lizard. LOSE: Lizard Eats Paper!");
            } else if (computerPlays == 5)//spock
            {
                System.out.println("The computer is Spock. WIN: Paper disproves Spock!");
            } else
            {
                System.out.println("The computer is Paper too. It's a tie!");
            }

        } else if (playerPlays == 3)//user isScissor
        {
            if (computerPlays == 1)//Rock
            {
                System.out.println("The computer is Rock. LOSE: Rock Crushes Scissors!");
            } else if (computerPlays == 2)//Paper
            {
                System.out.println("The computer is Paper. WIN: Scissors Cut Paper!");
            } else if (computerPlays == 4)//lizard
            {
                System.out.println("The computer is lizard. WIN: Scissors Decapitate Lizard!");
            } else if (computerPlays == 5)//spock
            {
                System.out.println("The computer is Spock. LOSE: Spock smashes Scissors!");
            } else
            {
                System.out.println("The computer is Scissor too. It's a tie!");
            }
        } else if (playerPlays == 4)//user is lizard
        {
            if (computerPlays == 1)//Rock
            {
                System.out.println("The computer is Rock. LOSE: Rock Crushes Lizard!");
            } else if (computerPlays == 2)//Paper
            {
                System.out.println("The computer is Paper. WIN: Lizard Eats Paper!");
            } else if (computerPlays == 3)//Scissors
            {
                System.out.println("The computer is lizard. LOSE: Scissors Decapitate Lizard!");
            } else if (computerPlays == 5)//spock
            {
                System.out.println("The computer is Spock. WIN: Lizard Poisons Spock!");
            } else
            {
                System.out.println("The computer is Lizard too. It's a tie!");
            }
        } else if (playerPlays == 5)//user is spock
        {
            if (computerPlays == 1)//Rock
            {
                System.out.println("The computer is Rock. WIN: Spock vaporizes Rock!");
            } else if (computerPlays == 2)//Paper
            {
                System.out.println("The computer is Paper. LOSE: Paper disproves Spock!");
            } else if (computerPlays == 3)//Scissors
            {
                System.out.println("The computer is Scissors. WIN: Spock smashes Scissors!");
            } else if (computerPlays == 4)//lizard
            {
                System.out.println("The computer is Lizard. LOSE: Lizard Poisons Spock!");
            } else
            {
                System.out.println("The computer is Spock too. It's a tie!");
            }
        }
    }
}
