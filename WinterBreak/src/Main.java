import java.util.Arrays;
import java.util.List;

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
        int[] arr = new int[]{1,2,3,4};
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        for (Integer i : list)
        {

        }
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