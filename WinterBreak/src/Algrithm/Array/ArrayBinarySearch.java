package Algrithm.Array;

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
public class ArrayBinarySearch
{
    //左右边界都包含的情况下
    public int BinarySearch(int[] array, int target)
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
    public int BinarySearchR(int[] array, int target)
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
}
