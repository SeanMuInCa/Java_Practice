package Algrithm.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public class WithMap
{
    public static int[] twoSum(int[] arr, int target)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
        {
            int find = target - arr[i];
            if(!map.containsKey(find))
            {
                map.put(arr[i],i);
            }else
            {
                return new int[]{map.get(find),i};
            }
        }
        return new int[0];
    }

    public static void main(String[] args)
    {
        int[] arr1 = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr1, 8)));
    }
}
