import java.math.BigInteger;

/**
 * Purpose:             To output sum of two integers. <br />
 * To use run the main method. <br />
 * Data Submitted:      2023/11/12 <br />
 * Assignment Number:   Lab 1  <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          PACKAGE_NAME <br />
 *
 * @author Zhenghua Mu (instructor - no SDC#)
 * @version 1.0.0
 */
public class TestStackOfIntegers
{
    public static void main(String[] args)
    {
        StackOfIntegers s = new StackOfIntegers();
        System.out.println(s);
        for (int i = 0; i < 20; i++)
        {
            s.push(i);
        }
        System.out.println(s);
        while (!s.empty()){
            System.out.print(s.pop() + " ");
        }
        Integer i1 = 1;
        Integer i2 = Integer.valueOf(1);
        int i3 = 1;
        Integer i4 = new Integer(1);
        Integer i5 = new Integer("1");
        System.out.println(i1 == i2);
        System.out.println(i2 == i3);
        System.out.println(i4 == i5);
        Integer[] intArray = {1, 2, 3};
        System.out.println(intArray[0] + intArray[1] + intArray[2]);
        BigInteger result = BigInteger.ONE;
        System.out.println(result);
        java.math.BigInteger x = new java.math.BigInteger("3");
        java.math.BigInteger y = new java.math.BigInteger("7");
        java.math.BigInteger z = x.add(y);
        System.out.println("x is " + x);
        System.out.println("y is " + y);
        System.out.println("z is " + z);
        String[] tokens = "Java,C?C#,C++".split("[,?]");
        for (int i = 0; i < tokens.length; i++)
            System.out.println(tokens[i]);
        String str = new String(new char[]{'J', 'a', 'v', 'a'});
        String str1 = String.valueOf(new char[]{'J', 'a', 'v', 'a'});
        System.out.println(str == str1);
        String str2 = "123abc";//exception
        int x1 = Integer.parseInt(str2);
        System.out.println(x1);
        StringBuilder sb = new StringBuilder();
    }
}
