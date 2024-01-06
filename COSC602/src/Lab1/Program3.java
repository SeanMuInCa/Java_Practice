package Lab1;

/**
 * Purpose:             Lab1<br />
 * Data Submitted:      2024/1/5 <br />
 * Assignment Number:    Lab1<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Program3
{
    public static void main(String[] args)
    {
        System.out.println(reverseDigits(1234));
    }
    public static int reverseDigits(int value){
        if((value + "").length() == 1){
            return value;
        }
        return (int) (reverseDigits(value / 10) + (value % 10) * Math.pow(10, (value + "").length() - 1));
    }
}
