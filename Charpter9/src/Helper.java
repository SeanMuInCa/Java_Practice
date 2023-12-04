import java.util.Arrays;

public class Helper
{
    static int a = 2;
    public static int b = 3;
    private static int c = 4;

    /**
     * 判断数组里是否有某个元素
     *
     * @param arr 数组int
     * @param num 值int
     * @return boolean
     */
    public static boolean contains(int[] arr, int num)
    {
        for (int j : arr)
        {
            if (num == j) return true;
        }
        return false;
    }

    /**
     * 包含的情况下，index是多少
     *
     * @param arr 数组
     * @param num 值int
     * @return int
     */
    public static int indexOf(int[] arr, int num)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (num == arr[i]) return i;
        }
        return -1;
    }

    /**
     * 从尾部切断数组，保留非0的部分
     *
     * @param nums 数组
     * @return 返回一个新数组
     */
    public static int[] cutArr(int[] nums)
    {
        int length = nums.length;
        for (int i = nums.length - 1; i > 0; i--)
        {
            if (nums[i] == 0)
            {
                length--;
            } else break;
        }
        int[] newArr = new int[length];
        System.arraycopy(nums, 0, newArr, 0, length);
        return newArr;
    }

    public static boolean isPrime(int number)
    {
        if (number <= 1) return false;
        else
        {
            for (int i = 2; i <= Math.pow(number, 0.5); i++)
            {
                if (number % i == 0) return false;
            }
            return true;
        }
    }

    public static int getRandomNumber(int min, int max)
    {
        return (int) (Math.random() * (max - min + 1)) + min;
    }


    public static void bubbleSort(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            // Find the minimum in the list[i..list.length−1]
            int currentMin = arr[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < arr.length; j++)//这里只是找最小值，没有操作数组
            {
                if (currentMin > arr[j])
                {
                    currentMin = arr[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary 这里操作数组
            if (currentMinIndex != i)
            {
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
    }

    public static void insertSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            while (arr[i - 1] > arr[i])
            {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
        }
    }

    public static int binarySearch(int[] arr, int val)
    {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right)
        {
            int mid = (right - left) / 2 + left;
            if (val > arr[mid])
            {
                left = mid + 1;
            } else if (val < arr[mid])
            {
                right = mid - 1;
            } else
            {
                return mid;
            }
        }
        return -left - 1;
    }

    public static int binarySearch(double[] arr, double val)
    {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right)
        {
            int mid = (right - left) / 2 + left;
            if (val > arr[mid])
            {
                left = mid + 1;
            } else if (val < arr[mid])
            {
                right = mid - 1;
            } else
            {
                return mid;
            }
        }
        return -left - 1;
    }

    public static int binarySearch(String[] arr, String val)
    {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right)
        {
            int mid = (right - left) / 2 + left;
            if (val.compareTo(arr[mid]) > 0)
            {
                left = mid + 1;
            } else if (val.compareTo(arr[mid]) < 0)
            {
                right = mid - 1;
            } else
            {
                return mid;
            }
        }
        return -left - 1;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 5, 6, 12, 4, 9, 3, 23, 39, 403, 596, 87};
//        double[] arr1 = {1.0, 5.1, 6.3, 12.56, 44.24};
//        String[] arr2 = {"a", "b", "c", "d"};
//        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        int x = binarySearch(arr, 39);
//        int y = binarySearch(arr1, 12.5);
//        int z = binarySearch(arr2, "d");
//        System.out.println(Arrays.toString(arr));
//        System.out.println(z);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right)
    {
        if (left < right)
        {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right)
    {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++)
        {
            if (arr[i] < arr[pivot])
            {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
