package Algrithm.Array;

import java.util.Arrays;

/**
 * Purpose:             Algrithm.Array<br />
 * Data Submitted:      2024/2/1 <br />
 * Assignment Number:    Algrithm.Array<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Algrithm.Array <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Array
{
    //左右边界都包含的情况下
    public static int BinarySearch(int[] array, int target)
    {
        int left = 0;
        int right = array.length - 1;

        while (left <= right)//这里是1小于还是小于等于，要看是否包含右边边界值
        {
            int mid = (left + right) / 2;
            if(array[mid] > target)
            {
                right = mid - 1;
            } else if (array[mid] < target)
            {
                left = mid + 1;
            }else return mid;
        }
        return - left - 1;
    }
    //有边界不包含
    public static int BinarySearchR(int[] array, int target)
    {
        int left = 0;
        int right = array.length;//不包含右
        int mid = (left + right) / 2;
        while (left < right)//这里是1小于还是小于等于，要看是否包含右边边界值
        {
            if(array[mid] > target)
            {
                right = mid;
            } else if (array[mid] < target)
            {
                left = mid + 1;
            }else return mid;
        }
        return - left - 1;
    }
    public static int[] delete1(int[] array, int key)//有问题，重复的值没法删除
    {
        int[] newArr = null;
        for (int i = 0; i < array.length; i++)
        {
            if(array[i] == key)
            {
                newArr = new int[array.length - 1];
                System.arraycopy(array,0,newArr,0,i);
                System.arraycopy(array,i+1,newArr,i,array.length - i -1);
                break;
            }
        }
        return newArr == null ? array : newArr;
    }
    //快指针移动，查找不符合的元素，并给到慢指针，让慢指针去更新数组
    public static int[] delete2(int[] array, int key)
    {
        int fast = 0;
        int slow = 0;
        for (; fast < array.length; fast++)
        {
            if(array[fast] != key)
            {
                array[slow] = array[fast];
                slow++;
            }
        }
        int[] newArr = new int[slow];
        System.arraycopy(array,0,newArr,0,newArr.length);
        return newArr;
    }

    //数组每个元素平方后再排序，这里可能有负数
    public static int[] afterSquare(int[] array)
    {
        int[] newArr = new int[array.length];
        int k = array.length - 1;
        for (int i = 0,j = array.length - 1; i <= j ; )
        {
            int a = array[i] * array[i];
            int b = array[j] * array[j];
            if(a > b)
            {
                newArr[k--] = a;
                i++;
            }else
            {
                newArr[k--] = b;
                j--;
            }
        }
        return newArr;
    }
    //minimum subarray length
    public int minSubArrayLen(int target, int[] nums)
    {
        int sum = 0;
        int left = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++)
        {
            sum += nums[right];
            while (sum >= target)
            {
                res = Math.min(res,right - left + 1);
                sum -= nums[left];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static void main(String[] args)
    {
        int[] arr = {-10,-9,2,3,4,5,6,7};
        System.out.println(BinarySearch(arr, -9));
//        System.out.println(BinarySearchR(arr, 4));
        /*int[] newArr = delete2(arr,3);
        System.out.println(Arrays.toString(newArr));*/
        System.out.println(Arrays.toString(arr));
        int[] newArr1 = afterSquare(arr);
        System.out.println(Arrays.toString(newArr1));
    }
}
