package Lab2;
import java.util.Scanner;
/**
 * Purpose:             Output the inputted value as different results using different Math methods. <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Lab 2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab2/Program2.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program2
{
    public static void main(String[] args)
    {
        int firstNum, exp;
        double resultExp, resultLog, resultRoot;

        //Create a Scanner object for input
        Scanner myInput = new Scanner(System.in);

        // Prompt the user to enter first number and exp number
        System.out.print("Input two numbers: ");
        firstNum = myInput.nextInt();
        exp = myInput.nextInt();

        //calculate the results
        resultExp = Math.pow(firstNum, exp);
        resultLog = Math.log10(firstNum);
        resultRoot = Math.sqrt(firstNum);

        //display the results
        System.out.println(firstNum+" Raised to the "+exp+" is "+resultExp);
        System.out.println("The log of "+firstNum+" is "+resultLog);
        System.out.println("The square root of "+firstNum+" is "+resultRoot);
    }
}
