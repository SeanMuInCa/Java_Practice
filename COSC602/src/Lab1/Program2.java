package Lab1;

/**
 * Purpose:             Lab1<br />
 * Data Submitted:      2024/1/5 <br />
 * Assignment Number:    Lab1<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Program2
{
    public static void main(String[] args)
    {
        System.out.println(generateGeometric(2, 5));
    }
    public static int generateGeometric(int i, int n){
        if(n <= 0) return 1;
        else return i * generateGeometric(i,n - 1);
    }
}
