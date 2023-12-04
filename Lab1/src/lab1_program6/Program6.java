package lab1_program6;

import java.util.Scanner;//import a lib
/**
 * @author Zhenghua Mu
 * @purpose: Ask user to input two numbers and do multiply
 */
public class Program6 {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        int firstNum, secondNum, result;// declare three variables
        System.out.print("Input first number: ");
        Scanner myInput = new Scanner(System.in);//declare a Scanner type variable assign with user's input
        firstNum = myInput.nextInt();//assign with user's first input
        System.out.print("Input second number: ");
        secondNum = myInput.nextInt();//assign with user's second input
        result = firstNum * secondNum;//assign with multiply result
        System.out.println("Product : " + firstNum + " x " + secondNum + " = " + result);
    }
}
