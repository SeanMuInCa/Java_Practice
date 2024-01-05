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
public class MergeSort {

    // 归并排序算法
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 递归地对左右两边进行排序
            mergeSort(arr, left, mid);//0,2  0,1  0,0
            mergeSort(arr, mid + 1, right);//3,4  4,4

            // 合并两个已排序的子数组
            merge(arr, left, mid, right);
        }
    }

    // 合并两个已排序的子数组
    public void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // 将数据复制到临时数组 L 和 R
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        // 合并临时数组到 arr
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 处理剩余元素（如果有）
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        MergeSort sorter = new MergeSort();
        sorter.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
