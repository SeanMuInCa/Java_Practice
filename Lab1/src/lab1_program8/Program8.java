package lab1_program8;

import java.util.Scanner;//import a lib

/**
 * @author Zhenghua Mu
 * @purpose: Ask user to input two numbers and do math
 */
public class Program8
{
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        int firstNum, secondNum, result;//declare three variables
        Scanner myCalcInput = new Scanner(System.in);//declare a Scanner type variable assign with user's input
        System.out.print("Input first number:");
        firstNum = myCalcInput.nextInt();//assign with first number
        System.out.print("Input second number:");
        secondNum = myCalcInput.nextInt();//assign with second number
        result = firstNum + secondNum;//do plus
        System.out.println(firstNum + " + " + secondNum + " = " + result);
        result = firstNum - secondNum;//do minus
        System.out.println(firstNum + " - " + secondNum + " = " + result);
        result = firstNum * secondNum;//do multiply
        System.out.println(firstNum + " x " + secondNum + " = " + result);
        result = firstNum / secondNum;//do division
        System.out.println(firstNum + " / " + secondNum + " = " + result);
        result = firstNum % secondNum;//do modulo
        System.out.println(firstNum + " mod " + secondNum + " = " + result);
    }
}
