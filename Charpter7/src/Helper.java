import java.util.Arrays;

public class Helper
{
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

    public static void main(String[] args)
    {
        int[] arr = {1, 5, 6, 12, 4, 9, 3, 23, 39, 403, 596, 87};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
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

}
