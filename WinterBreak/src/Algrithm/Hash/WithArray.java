package Algrithm.Hash;

import java.util.Arrays;

/**
 * Purpose:             Algrithm.Hash<br />
 * Data Submitted:      2024/2/4 <br />
 * Assignment Number:    Algrithm.Hash<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Algrithm.Hash <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class WithArray
{
    //当数据量可控，可以用数组。如果太大就用set，如果含k-v在考虑用map

    //判断两个字符串，是否是相同字母组成？相同字母的个数也相同。
    //简单想，可以用两个循环来解决这个题。
    public static boolean theyBothEqual(String s1, String s2)
    {
        if(s1.length() != s2.length()) return false;
        int[] alphabet = new int[26];
        for (int i = 0; i < s1.length(); i++)
        {
            char c = s1.charAt(i);
            int index = c - 'a';
            alphabet[index]++;
        }
        for (int i = 0; i < s2.length(); i++)
        {
            char c = s2.charAt(i);
            int index = c - 'a';
            alphabet[index]--;
        }
        return Arrays.stream(alphabet).allMatch(i -> i == 0);
    }

    public static void main(String[] args)
    {
        System.out.println(theyBothEqual("abca", "bcaa"));
    }
}
