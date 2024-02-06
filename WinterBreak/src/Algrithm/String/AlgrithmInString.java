package Algrithm.String;

/**
 * Purpose:             Algrithm.String<br />
 * Data Submitted:      2024/2/5 <br />
 * Assignment Number:    Algrithm.String<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Algrithm.String <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class AlgrithmInString
{
    public static String recReverse(String str)
    {
        if(str.isEmpty()) return "";
        return recReverse(str.substring(1)) + str.charAt(0);
    }
    public static void twoPointersReverse(String str)
    {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right)
        {
            char a = str.charAt(left);
            char b = str.charAt(right);
            char temp = a;
            a = b;
            b = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args)
    {
        String str = "abcdefg";
//        System.out.println(recReverse(str));
        twoPointersReverse(str);
        System.out.println(str);
    }
}
