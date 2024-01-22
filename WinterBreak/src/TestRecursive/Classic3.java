package TestRecursive;

import java.util.Arrays;

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
public class Classic3
{
    /**
     * n个对象的一个排列，就是把这 n 个不同的
     * 对象放在同一行上的一种安排。例如，对于
     * 三个对象 a,b,c，总共有6个排列：n 个对象的排列个数就是 n!
     */
    static char[] a = {'a','b','c'};
    public static void main(String[] args)
    {

        f(0);
    }

    private static void f(int i)
    {
        if(i >= a.length)
        {
            System.out.println(Arrays.toString(a));
            return;
        }else
        {
            for (int j = i; j < a.length; j++)
            {
                char temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                f(i + 1);
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
    }
}
