package TestThreadTextBook;

/**
 * Purpose:             TestThreadTextBook<br />
 * Data Submitted:      2024/3/9 <br />
 * Assignment Number:    TestThreadTextBook<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          TestThreadTextBook <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class QuickSort
{
    public static void quickSort(int[] list)
    {
        quickSort(list, 0, list.length - 1);
    }
    public static void quickSort(int[] list, int left, int right)
    {
        if(right > left)
        {
            int pivotIndex = partition(list, left, right);
            quickSort(list, left, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, right);
        }
    }
    public static int partition(int[] list, int left, int right)
    {
        int pivot = list[left];
        int low = left + 1;
        int high = right;

        while (low < high)
        {
            while (low <= high && list[low] <= pivot)
            {
                low++;
            }
            while (low <= high && list[high] > pivot)
            {
                high--;
            }
            if(high > low)
            {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while (high > left && list[high] >= pivot)
        {
            high--;
        }
        if(pivot > list[high])
        {
            list[left] = list[high];
            list[high] = pivot;
            return high;
        }else
        {
            return left;
        }
    }

    public static void main(String[] args)
    {
        int[] list = {2,3,2,5,6,1,-2,3,14,12};
        long startTime = System.currentTimeMillis();
        quickSort(list);
        long endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");
        System.out.println();
        for (int i : list)
        {
            System.out.print(i + " ");
        }
    }
}
