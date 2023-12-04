package assign2SDC000506980;

/**
 * Purpose:             To displays all these perfect numbers between 1 and 10,000 <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   Assignment2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           assign2SDC000506980/Q2 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Q2
{
    public static void main(String[] args)
    {

        System.out.print("The perfect numbers between 1 and 10,000 are: ");
        //1 is not a perfect number so start from 1
        for (int i = 2; i <= 10000; i++)
        {
            System.out.print(isNumberPerfect(i) ? i + " " : "");
        }
    }

    /**
     * To chcek a number is perfect number or not
     *
     * @param number int input a number
     * @return boolean is perfect number or not
     */
    public static boolean isNumberPerfect(int number)
    {
        int sum = 1;
        for (int i = 2; i <= number / 2; i++)
        {
            if (number % i == 0)
            {
                sum += i;
            }
        }
        return sum == number;
    }
}
