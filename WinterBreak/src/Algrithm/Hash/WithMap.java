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

    //判断四个数组里，有没有四个数字相加等于0，返回有多少组
    public static int sumOfFour(int[] arr1,int[] arr2,int[] arr3,int[] arr4)
    {
        Map<Integer,Integer> map1 = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr1.length; i++)
        {
            for (int j = 0; j < arr2.length; j++)
            {
                int key = arr1[i] + arr2[j];
                if(!map1.containsKey(key))
                {
                    map1.put(key,1);
                }else
                {
                    int val = map1.get(key);
                    map1.put(key,++val);
                }
            }
        }
        for (int i = 0; i < arr3.length; i++)
        {
            for (int j = 0; j < arr4.length; j++)
            {
                int key = arr3[i] + arr4[j];
                int find = -key;
                if(map1.containsKey(find))
                {
                    count += map1.get(find);
                }
            }
        }
        return count;
    }


    public static int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxFreq = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int freq = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, freq);
            maxFreq = Math.max(maxFreq, freq);
            countMap.put(freq, countMap.getOrDefault(freq, 0) + 1);

            int countOfMaxFreq = countMap.get(maxFreq);
            int totalCount = maxFreq * countOfMaxFreq;

            if (totalCount == (maxFreq - 1) * (countOfMaxFreq - 1) || totalCount == maxFreq * (countOfMaxFreq - 1) + 1) {
                result = Math.max(result, i + 1);
            }
        }

        return result;
    }
    public static void main(String[] args)
    {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {-2,-1};
        int[] arr3 = {-1,2};
        int[] arr4 = {0,2};
        int[] nums = {1,2,2,3,4};
        System.out.println(Arrays.toString(twoSum(arr1, 5)));
        System.out.println(maxEqualFreq(nums));
        //System.out.println(sumOfFour(arr1,arr2,arr3,arr4));
    }
}
