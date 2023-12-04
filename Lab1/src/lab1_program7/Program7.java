package lab1_program7;

import java.util.Scanner;//import a lib

/**
 * @author Zhenghua Mu
 * @purpose: get user's input and multiply 10
 */
public class Program7
{
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        float inputNum, result;//declare two variables
        System.out.print("Input number: ");
        Scanner numInput = new Scanner(System.in);//declare a Scanner type variable assign with user's input
        inputNum = numInput.nextFloat();//assign with user's input
        result = inputNum * 10;//assign with user's input multiply 10
        System.out.println("Product : " + inputNum + " x " + 10 + " = " + (int) result);
    }
}
