package TestRecursive;

import java.util.Scanner;

/**
 * Purpose:             TestRecursive<br />
 * Data Submitted:      2024/1/22 <br />
 * Assignment Number:    TestRecursive<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestRecursive <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Classic2
{
    /**
     * 给定一个十进制整数，返回其对应的二进制数的位数。例如，输入十进制数9，其对应的二进制数是1001，因此位数是4。
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        System.out.println(f(a));
    }

    private static int f(int a)
    {
        if(a == 0) return 0;
//        if(a == 1) return 1;
        return 1 + f(a / 2);
    }
}
