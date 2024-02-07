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

    /**
     * 不使用Java内置方法实现
     * <p>
     * 1.去除首尾以及中间多余空格
     * 2.反转整个字符串
     * 3.反转各个单词
     */
    public static String reverseWords(String s)
    {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
//        sb.reverse();
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }
    private static StringBuilder removeSpace(String s) {
        s = s.trim();
        int start = 0;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
    public static void main(String[] args)
    {
        String str = "abcdefg";
//        System.out.println(recReverse(str));
        System.out.println(twoPointersReverse(str));
        System.out.println(reverseWords(" the   sky   is   blue"));
    }
}
