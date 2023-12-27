/**
 * Purpose:             <br />
 * Data Submitted:      2023/12/6 <br />
 * Assignment Number:    <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:           <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Main
{
    public static void main(String[] args)
    {
        extracted();
        System.out.println("Hello world!");

        hanoi(3, 'A', 'B', 'C');
    }

    public static void hanoi(int n, char A, char B, char C)
    {
        if (n == 1)
        {
            System.out.println(n + " from " + A +" ----> " + C);
        } else
        {
            hanoi(n - 1, A, C, B);
            System.out.println(n + " from " + A +" ----> " + C);
            hanoi(n - 1, B, A, C);
        }
    }

    private static void extracted()
    {
        int m = 10;
        int n = 20;
        int temp = m;
        m = n;
        n = temp;
        System.out.println(m + " " + n);
    }

}