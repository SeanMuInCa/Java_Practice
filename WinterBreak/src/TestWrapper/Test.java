package TestWrapper;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose:             TestWrapper<br />
 * Data Submitted:      2023/12/12 <br />
 * Assignment Number:    TestWrapper<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestWrapper <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Test
{
@org.junit.Test
public void test(){

    System.out.println("Hello World!");
    Scanner sc = new Scanner(System.in);
    System.out.println(sc.nextInt());
}
    public static void main(String[] args)
    {
        int num = 10;
        String s = "30";
        Integer i = Integer.valueOf(num);
        System.out.println(i);

        Double d = Double.valueOf(s);
        System.out.println(Double.valueOf(s));

        System.out.println("--------------------");
        Integer i1 = 11;
        int val = i1;
        System.out.println(++val);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);

    }
    @org.junit.Test
    public void test1(){

    }
}
