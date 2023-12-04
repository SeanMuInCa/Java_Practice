package lab1_program9;

import java.util.Scanner;//import a lib

/**
 * @author Zhenghua Mu
 * @purpose: Ask user to input a number and do multiply with 1-10
 */
public class Program9
{
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        int multTableNum;//declare a variable
        Scanner myMultInput = new Scanner(System.in);//declare a Scanner type variable assign with user's input
        System.out.print("Input a number: ");
        multTableNum = myMultInput.nextInt();//assign with user's input
        for (int i = 1; i < 11; i++) {//a loop helps me to print 10 times
            System.out.println(multTableNum + " x " + i + " = " + multTableNum * i);
        }
    }
}
