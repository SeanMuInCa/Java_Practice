package Algrithm.Hash;

import java.util.HashSet;
import java.util.Set;

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
public class WithSet
{
    public static Set<Integer> getDuplication(int[] arr1, int[] arr2)
    {
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return null;
        }
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr1)
        {
            set.add(i);
        }
        for (int i = 0; i < arr2.length; i++)
        {
            if(set.contains(arr2[i]))
            {
                res.add(arr2[i]);
            }
        }
        int[] array = res.stream().mapToInt(x -> x).toArray();
        return res;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {1,2,3,4,4};
        int[] arr2 = {4,4,6,7,8};
        System.out.println(getDuplication(arr1,arr2));
    }
}
