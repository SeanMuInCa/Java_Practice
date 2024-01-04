package TestRecursive;

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
public class QuickSort {

    // 快速排序算法
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // 对基准值左边的子数组进行快速排序
            quickSort(arr, low, pi - 1);

            // 对基准值右边的子数组进行快速排序
            quickSort(arr, pi + 1, high);
        }
    }

    // 分区函数，将数组分成两部分并返回基准值的位置
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准值
        int i = low - 1; // 记录小于基准值的元素的索引

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // 交换元素
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 将基准值放到正确的位置
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // 返回基准值的索引
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort sorter = new QuickSort();
        sorter.quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

