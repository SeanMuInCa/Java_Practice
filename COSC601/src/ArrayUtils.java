/**
 * Purpose:            To implement some useful methods of array <br />
 * Data Submitted:      10/31/2023 <br />
 * Assignment Number:   Lab 2  <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab2/ArrayUtils <br />
 *
 * @author Zhenghua Mu
 * @version 2.0.0
 */
public class ArrayUtils
{
    /**
     * find the max element in an array
     *
     * @param arr an int array
     * @return the max value
     */
    public static int max(int[] arr)
    {
        int max = arr[0];
        for (int item : arr)
        {
            if (item > max)
            {
                max = item;
            }
        }
        return max;
    }

    /**
     * find the min element in an array
     *
     * @param arr an int array
     * @return the min value
     */
    public static int min(int[] arr)
    {
        int min = arr[0];
        for (int item : arr)
        {
            if (item < min)
            {
                min = item;
            }
        }
        return min;
    }

    /**
     * calculate the sum of all elements of an array
     *
     * @param arr an int array
     * @return the sum of all elements
     */
    public static int total(int[] arr)
    {
        int sum = 0;
        for (int item : arr)
        {
            sum += item;
        }
        return sum;
    }

    /**
     * count odd element in an array
     *
     * @param arr an int array
     * @return how many odd elements
     */
    public static int countOdd(int[] arr)
    {
        int counterOdd = 0;
        for (int value : arr)
        {
            if (value % 2 != 0)
            {
                counterOdd++;
            }
        }
        return counterOdd;
    }

    /**
     * display a format array
     *
     * @param arr an int array
     * @return a string of formatted array
     */
    public static String toString(int[] arr)
    {
        String result = "[";
        int counter = 0;
        for (int strVal : arr)
        {
            result += strVal + ", ";
            counter++;
            if (counter % 10 == 0)
            {
                result += "\n";
            }
        }
        result = result.substring(0, result.lastIndexOf(',')) + "]";
        return result;
    }

    /**
     * display a format array in reverse way
     *
     * @param arr an int array
     * @return a string of formatted array
     */
    public static String reverseToString(int[] arr)
    {
        String result = "[";
        int counter = 0;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            result += arr[i] + ", ";
            counter++;
            if (counter % 10 == 0)
            {
                result += "\n";
            }
        }
        result = result.substring(0, result.lastIndexOf(',')) + "]";
        return result;
    }

    /**
     * count how many times an element in an array
     *
     * @param arr an int array
     * @param key an int value
     * @return how many times the key value occurs in array
     */
    public static int timesOccur(int[] arr, int key)
    {
        int countTimes = 0;
        for (int value : arr)
        {
            if (value == key)
            {
                countTimes++;
            }
        }
        return countTimes;
    }

    /**
     * reverse an array
     *
     * @param arr an int array
     * @return a new array in reverse way
     */
    public static int[] reverse(int[] arr)
    {
        int[] returnArr = new int[arr.length];
        int counter = 0;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            returnArr[counter] = arr[i];
            counter++;
        }
        return returnArr;
    }

    /**
     * determine a value is odd or not
     *
     * @param value an int value
     * @return true if the value is odd, false is not odd
     */
    public static boolean isOdd(int value)
    {
        return value % 2 != 0;
    }

    /**
     * determine a value is even or not
     *
     * @param value an int value
     * @return true if the value is even, false is not even
     */
    public static boolean isEven(int value)
    {
        return value % 2 == 0;
    }

    /**
     * collect all the odd values from an array
     *
     * @param arr an int array
     * @return a new value contains only odd elements
     */
    public static int[] oddValues(int[] arr)
    {
        int[] returnArr = new int[countOdd(arr)];
        int counter = 0;
        for (int j : arr)
        {
            if (j % 2 != 0)
            {
                returnArr[counter++] = j;
            }
        }
        return returnArr;
    }

    /**
     * copy a new array
     *
     * @param arr an int array
     * @return a new array copied from the input array
     */
    public static int[] copyArr(int[] arr)
    {
        int[] returnArr = new int[arr.length];
        int counter = 0;
        for (int arrVal : arr)
        {
            returnArr[counter++] = arrVal;
        }
        return returnArr;
    }

    /**
     * copy an array with specific length
     *
     * @param arrSrc  source array
     * @param arrDest destination array
     * @param sizeCpy the size copied from source array to destination array
     */
    public static void copy(int[] arrSrc, int[] arrDest, int sizeCpy)
    {
        int minArraySize = Math.min(arrSrc.length, arrDest.length);
        int copySize = Math.min(minArraySize, sizeCpy);
        for (int i = 0; i < copySize; i++)
        {
            arrDest[i] = arrSrc[i];
        }
    }

    /**
     * reduce the array size
     *
     * @param arr   source array
     * @param value the new array length
     * @return a new array with the same values as source array but specific length
     */
    public static int[] reduce(int[] arr, int value)
    {
        int size = Math.min(arr.length, value);
        int[] returnArr = new int[size];
        copy(arr, returnArr, size);
        return returnArr;
    }

    /**
     * increase the array size
     *
     * @param arr   source array
     * @param value the new array increased value
     * @return a new array with the same values as source array but specific length
     */
    public static int[] grow(int[] arr, int value)
    {
        int newSize = arr.length + value;
        if (newSize <= 0) return null;
        int[] returnArr = new int[newSize];
        copy(arr, returnArr, newSize);
        return returnArr;
    }

    /**
     * initial an int array with random number between 1 - 100
     *
     * @param arr an int empty array
     * @return an array initialed with int value
     */
    public static int[] randomInitIntArray(int[] arr)
    {
        if (arr.length > 0)
        {
            for (int i = 0; i < arr.length; i++)
            {
                arr[i] = getRandomInt(1, 100);
            }
        }
        return arr;
    }

    /**
     * initial an double array with random number between 1 - 100
     *
     * @param arr an double empty array
     * @return an array initialed with double value
     */
    public static double[] randomInitDoubleArray(double[] arr)
    {
        if (arr.length > 0)
        {
            for (int i = 0; i < arr.length; i++)
            {
                arr[i] = getRandomDouble(1, 100);
            }
        }
        return arr;
    }

    /**
     * generate random int number
     *
     * @param min min value
     * @param max max value
     * @return new random int number between min and max
     */
    private static int getRandomInt(int min, int max)
    {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * generate random double number
     *
     * @param min min value
     * @param max max value
     * @return new random double number between min and max
     */
    private static double getRandomDouble(double min, double max)
    {
        return (int)(((Math.random() * (max - min + 1)) + min) * 100) / 100.0;
    }

    /**
     * swap two elements in an array
     *
     * @param arr an array
     * @param i   one of the index
     * @param j   one of the index
     */
    public static void swap(double arr[], int i, int j)
    {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * swap two elements in an array
     *
     * @param arr an array
     * @param i   one of the index
     * @param j   one of the index
     */
    public static void swap(char arr[], int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * swap two elements in an array
     *
     * @param arr an array
     * @param i   one of the index
     * @param j   one of the index
     */
    public static void swap(String arr[], int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * search a value in an array using binary search
     *
     * @param arr target array
     * @param val looking for value
     * @return index of the value or index if this value is in the array
     */
    public static int binarySearchForDouble(double[] arr, double val)
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

    /**
     * search a value in an array using binary search
     *
     * @param arr target array
     * @param val looking for value
     * @return index of the value or index if this value is in the array
     */
    public static int binarySearchForString(String[] arr, String val)
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

    /**
     * sort an array using selection sort
     *
     * @param arr an int array
     */
    public static void selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
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

            //  这里操作数组
            if (currentMinIndex != i)
            {
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
    }

    /**
     * sort an array using selection sort
     *
     * @param arr an doulbe array
     */
    public static void selectionSort(double[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            double currentMin = arr[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < arr.length; j++)//这里只是找最小值，没有操作数组
            {
                if (currentMin > arr[j])
                {
                    currentMin = arr[j];
                    currentMinIndex = j;
                }
            }

            //  这里操作数组
            if (currentMinIndex != i)
            {
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
    }

    /**
     * sort an array using selection sort
     *
     * @param arr an char array
     */
    public static void selectionSort(char[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            char currentMin = arr[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < arr.length; j++)//这里只是找最小值，没有操作数组
            {
                if (currentMin > arr[j])
                {
                    currentMin = arr[j];
                    currentMinIndex = j;
                }
            }

            // 这里操作数组
            if (currentMinIndex != i)
            {
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
    }

    /**
     * sort an array using selection sort
     *
     * @param arr a String array
     */
    public static void selectionSort(String[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            String currentMin = arr[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < arr.length; j++)//这里只是找最小值，没有操作数组
            {
                if (currentMin.compareTo(arr[j]) > 0)
                {
                    currentMin = arr[j];
                    currentMinIndex = j;
                }
            }

            //  这里操作数组
            if (currentMinIndex != i)
            {
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
    }

    /**
     * sort an array using insert sort
     * @param arr an int array
     */
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
    /**
     * sort an array using insert sort
     * @param arr an double array
     */
    public static void insertSort(double[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            while (i > 0 && arr[i - 1] > arr[i])
            {
                double temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
        }
    }
    /**
     * sort an array using insert sort
     * @param arr a char array
     */
    public static void insertSort(char[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            while (i > 0 && arr[i - 1] > arr[i])
            {
                char temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
        }
    }
    /**
     * sort an array using insert sort
     * @param arr a String array
     */
    public static void insertSort(String[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            while (i > 0 && arr[i - 1].compareTo(arr[i]) > 0)
            {
                String temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
        }
    }
}
