package Lab4;
/**
 * Purpose:             Display the multiplication table for numbers 1-9<br />
 * Data Submitted:      9/26/2023 <br />
 * Assignment Number:   Lab 4  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab4/Program1.java <br />
 *
 * @author Zhenghua Mu #000506980
 * @version 1.0.0
 */
public class Program1
{
    public static void main(String[] args)
    {
        //9 rows
        for (int i = 1; i < 10; i++)
        {
            //9 cols
            for (int j = 1; j < 10; j++)
            {
                //display i*j in each cols
                System.out.print(i + " * " + j + " = " + i * j + "\t");
            }
            //change to next line after 9 cols is filled
            System.out.println("");
        }
    }
}
