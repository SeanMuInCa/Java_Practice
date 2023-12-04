import java.util.Arrays;

/**
 * Purpose:             PACKAGE_NAME<br />
 * Data Submitted:      2023/11/15 <br />
 * Assignment Number:    PACKAGE_NAME<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          PACKAGE_NAME <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Test02
{
    public static void main(String[] args)
    {
        int[] arr = {5,4,66,72,34,234};
        int[] arr1 = {5,4,66,72,34,235};
//        Arrays.sort(arr);
        int x = Arrays.binarySearch(arr,6);
        System.out.println(Arrays.compare(arr, arr1));
        System.out.println(x);
        printArr(arr);
    }

    private static void printArr(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
