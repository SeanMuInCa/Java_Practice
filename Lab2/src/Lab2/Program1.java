package Lab2;

/**
 * Purpose:             To calculate the 2 power of 8. <br />
 * Data Submitted:      9/12/2023 <br />
 * Assignment Number:   Lab 2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab2/Program1.java <br />
 * @author              Zhenghua Mu #000506980
 * @version            1.0.0
 */
public class Program1
{
    public static void main(String[] args){

        //declare variables
        int x, exponent, result;
        x = 2;
        exponent = 8;

        //calculate the result using math lib
        result = (int) Math.pow(x, exponent);

        //display the result
        System.out.println("The result of "+x+" power of "+exponent+" is: "+result);
    }
}
