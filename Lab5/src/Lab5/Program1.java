package Lab5;

/**
 * Purpose:             To find the smallest number among three numbers <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   lab5  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           lab5/Program1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Program1
{
    /**
     * To find the smallest number among three numbers
     *
     * @param num1 int first number
     * @param num2 int second number
     * @param num3 int third number
     * @return int the smallest number of all three params
     */
    public static int smallest(int num1, int num2, int num3)
    {
        int result;
        if (num1 < num2)
        {
            result = num1;
            if (num3 < num1)
            {
                result = num3;
            }
        } else
        {
            result = num2;
            if (num3 < num2)
            {
                result = num3;
            }
        }
        return result;
    }
}
