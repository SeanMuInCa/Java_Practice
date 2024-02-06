package Algrithm.String;

import java.util.Arrays;

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
        if (str.isEmpty()) return "";
        return recReverse(str.substring(1)) + str.charAt(0);
    }

    public static String twoPointersReverse(String str)
    {
        char[] s = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left < right)
        {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return Arrays.toString(s);
    }

    public static String reverseK(String str, int k)
    {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k)
        {
            int start = i;
            // 判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);
            while (start < end)
            {

                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch);
    }

    public static void main(String[] args)
    {
        String str = "abcdefg";
//        System.out.println(recReverse(str));
        System.out.println(twoPointersReverse(str));
    }
}
