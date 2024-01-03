package TestRecursive;

import org.junit.Test;

/**
 * Purpose:             TestRecursive<br />
 * Data Submitted:      2024/1/3 <br />
 * Assignment Number:    TestRecursive<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestRecursive <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestRecursive
{
    @Test
    public void test()
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(recursiveSearch(arr, 6, 0, arr.length - 1));
        hanoi(5, 'A', 'B', 'C');
    }

    public static int binSearch(int[] naVals, int nSearch)
    {
        int nLow = 0;
        int nHigh = naVals.length - 1;
        while (nHigh >= nLow)
        {
            int nMid = (nHigh + nLow) / 2;
            //Is the element in the upper 1/2/ of the array
            if (nSearch > naVals[nMid])
            {
                nLow = nMid + 1;
            } else
            {
                //Is the element in the bottom 1/2 of the array.
                if (nSearch < naVals[nMid])
                {
                    nHigh = nMid - 1;
                } else
                {
                    return nMid;
                }
            }
        }
        return -1;
    }

    public static int recursiveSearch(int[] arr, int key, int left, int right)
    {
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            if (key > arr[mid]) return recursiveSearch(arr, key, mid + 1, right);
            return recursiveSearch(arr, key, 0, mid - 1);
        }
        return -1;
    }

    public static void hanoi(int n, char A, char B, char C)
    {
        if (n == 1)
        {
            System.out.println(n + " from " + A + " ----> " + C);
        } else
        {
            hanoi(n - 1, A, C, B);
            System.out.println(n + " from " + A + " ----> " + C);
            hanoi(n - 1, B, A, C);
        }
    }
}
