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
public class Program1
{
    public static void main(String[] args)
    {
        System.out.println(generateTriangular(1));
        System.out.println(generateTriangular(2));
        System.out.println(generateTriangular(3));
        System.out.println(generateTriangular(4));
        System.out.println(generateTriangular(0));
        System.out.println(generateTriangular(-1));
    }

    public static int generateTriangular(int n)
    {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        else return n + generateTriangular(n - 1);
    }
}
