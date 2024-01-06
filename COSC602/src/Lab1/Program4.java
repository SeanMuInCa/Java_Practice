package Lab1;

import java.util.Arrays;

/**
 * Purpose:             Lab1<br />
 * Data Submitted:      2024/1/5 <br />
 * Assignment Number:    Lab1<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Program4
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{53, 32, 45, 67, 89, 12, 34, 56, 78, 90};
//        recBubbleSort(arr);
        recInsertionSort(arr);
        for (int a : arr)
        {
            System.out.print(a + " ");
        }
    }

    public static void recInsertionSort(int[] arr)
    {
        recInsertionSort(arr, arr.length - 1);
    }

    private static void recInsertionSort(int[] arr, int restLength)
    {
        if(restLength == 1) return;
        for (int i = 0; i < restLength - 1; i++)
        {
            if (arr[i] > arr[i + 1])
            {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        recInsertionSort(arr, restLength - 1);
    }

    public static void recBubbleSort(int[] arr)
    {
        recBubbleSort(arr, arr.length - 1);
    }

    private static void recBubbleSort(int[] arr, int restLength)
    {
        if (restLength == 1) return;
        for (int i = 0; i < restLength - 1; i++)
        {
            if (arr[i] > arr[i + 1])
            {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        recBubbleSort(arr, restLength - 1);
    }

    //insertion sort
    public static void insertSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            while (i > 0 && arr[i - 1] > arr[i])
            {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
        }
    }

    //bubble sort
    public static void bubbleSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                if (arr[i] < arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
