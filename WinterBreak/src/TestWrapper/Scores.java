package TestWrapper;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * Purpose:             TestWrapper<br />
 * Data Submitted:      2023/12/13 <br />
 * Assignment Number:    TestWrapper<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestWrapper <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Scores
{
    public static void main(String[] args)
    {
        Vector<Integer> v = getIntegers();
        if (v == null) return;
        int highest = v.get(v.size() - 1);
        extracted(v, highest);
    }

    private static void extracted(Vector<Integer> v, int highest)
    {
        for(int i = 0; i < v.size(); i++){
            if(highest - v.get(i)  <= 10){
                System.out.println("student " + (i + 1) + " get " + v.get(i) + " , with rank A");
            } else if (highest - v.get(i)  <= 20)
            {
                System.out.println("student " + (i + 1) + " get " + v.get(i) + " , with rank B");
            } else if (highest - v.get(i)  <= 30)
            {
                System.out.println("student " + (i + 1) + " get " + v.get(i) + " , with rank C");
            }else{
                System.out.println("student " + (i + 1) + " get " + v.get(i) + ", with rank D");
            }
        }
    }

    private static Vector<Integer> getIntegers()
    {
        Vector<Integer> v  = new Vector<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("how many students: ");
        int number = sc.nextInt();
        if(number <= 0) return null;
        for (int i = 0; i < number; i++)
        {
            System.out.println("enter score: ");
            int score = sc.nextInt();
            v.add(score);
        }
        sc.close();
        Collections.sort(v);
        System.out.println("The highest score is " + v.get(v.size() - 1));
        return v;
    }
}
