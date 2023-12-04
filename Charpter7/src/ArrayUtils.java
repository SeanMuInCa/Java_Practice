public class ArrayUtils
{
    /**
     * find the max element in an array
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
     * @param value an int value
     * @return true if the value is odd, false is not odd
     */
    public static boolean isOdd(int value)
    {
        return value % 2 != 0;
    }
    /**
     * determine a value is even or not
     * @param value an int value
     * @return true if the value is even, false is not even
     */
    public static boolean isEven(int value)
    {
        return value % 2 == 0;
    }

    /**
     * collect all the odd values from an array
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
     * @param arrSrc source array
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
     * @param arr source array
     * @param value the new array length
     * @return a new array with the same values as source array but specific length
     */
    public static int[] reduce(int[] arr, int value)
    {
        int size = Math.min(arr.length, value);
        int[] returnArr = new int[size];
        copy(arr, returnArr ,size);
        return returnArr;
    }
    /**
     * increase the array size
     * @param arr source array
     * @param value the new array increased value
     * @return a new array with the same values as source array but specific length
     */
    public static int[] grow(int[] arr, int value)
    {
        int newSize = arr.length + value;
        if(newSize <= 0) return null;
        int[] returnArr = new int[newSize];
        copy(arr, returnArr ,newSize);
        return returnArr;
    }
}
