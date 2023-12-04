package lab1_program5;

import java.util.Scanner;//import a lib

/**
 * @author Zhenghua Mu
 * @purpose: Ask user to input some strings and print it out
 */
public class Program5
{
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        String myString;//declare a variable without assign value
        System.out.print("Input a string: ");
        Scanner stringInput = new Scanner(System.in);//declare a Scanner type variable assign with user's input
        myString = stringInput.nextLine();//assign the variable with Scanner type variable's strings
        System.out.println(myString);
    }
}
