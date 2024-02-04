package Algrithm.Hash;

import java.util.ArrayList;
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

    //判断两个数组有重复的没,数组长度不大于1000
    public static int[] getDuplication(int[] arr1, int[] arr2)
    {
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return null;
        }
        int index = 0;
        int[] temp = new int[1001];
        int[] res = null;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++)
        {
            temp[arr1[i]] = 1;
        }
        for (int i = 0; i < arr2.length; i++)
        {
            if(temp[arr2[i]] == 1)
            {
                list.add(arr2[i]);
                temp[arr2[i]] = 0;//重新赋值回去，防止重复
            }
        }
        res = new int[list.size()];
        for (Integer i : list)
        {
            res[index++] = i;
        }
        return res;
    }
    //两数之和
    public static int[] twoSum(int[] arr, int target)
    {
        ArrayList<Integer> res = new ArrayList();
        for (int i = 0; i < arr.length; i++)
        {
            int find = target - arr[i];
            for (int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] == find)
                {
                    res.add(i);//return index
                    res.add(j);
                    return res.stream().mapToInt(x -> x).toArray();
                }
            }
        }
        return new int[0];
    }
    public static void main(String[] args)
    {
        System.out.println(theyBothEqual("abca", "bcaa"));
        int[] arr1 = {3,2,4};
        int[] arr2 = {4,4,6,7,8};
        System.out.println(Arrays.toString(getDuplication(arr1, arr2)));
        System.out.println(Arrays.toString(twoSum(arr1, 6)));

    }
}
