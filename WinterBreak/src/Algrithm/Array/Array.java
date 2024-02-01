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
        int mid = (left + right) / 2;
        while (left <= right)//这里是1小于还是小于等于，要看是否包含右边边界值
        {
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

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,3};
        System.out.println(BinarySearch(arr, 4));
//        System.out.println(BinarySearchR(arr, 4));
        int[] newArr = delete2(arr,3);
        System.out.println(Arrays.toString(newArr));
    }
}
