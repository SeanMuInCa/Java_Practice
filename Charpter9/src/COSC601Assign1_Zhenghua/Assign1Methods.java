package COSC601Assign1_Zhenghua;

/**
 * Purpose:             Practice <br />
 * Data Submitted:      11/7/2023 <br />
 * Assignment Number:   Assignment1  <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:           COSC601Assign1_Zhenghua/Assign1Methods <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.1
 */
public class Assign1Methods
{

    public static int arrayMedium(int[] aTest)
    {
        if (aTest.length == 0) return -1;
        insertSort(aTest,true);
        return (aTest.length % 2 == 0) ? aTest[aTest.length / 2 - 1] : aTest[aTest.length / 2];
    }

    public static int[] getOddValues(int[] aTest)
    {
        int[] newArr = {};
        for (int value : aTest)
        {
            if (value % 2 != 0)
            {
                newArr = add(newArr,value);
            }
        }
        insertSort(newArr,false);
        return newArr;
    }

    public static int[] add(int[] arr, int ...args){
        int[] newArr = new int[arr.length + args.length];
        for (int i = 0; i < arr.length; i++)
        {
            newArr[i] = arr[i];
        }
        for (int i = 0; i < args.length; i++)
        {
            newArr[i + arr.length] = args[i];
        }
        return newArr;
    }

    public static int[] joinArray(int[] aOne, int[] aTwo)
    {
        int[] newArray = {};
        for (int i = 0; i < aOne.length; i++)
        {
            newArray = add(newArray, aOne[i]);
        }
        for (int i = 0; i < aTwo.length; i++)
        {
            newArray = add(newArray, aTwo[i]);
        }
        insertSort(newArray, false);
        return newArray;
    }

    public static void insertSort(int[] arr, boolean increment)
    {
        for (int i = 1; i < arr.length; i++)
        {
            if (increment)
            {
                while (i > 0 && arr[i - 1] > arr[i])
                {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    i--;
                }
            } else
            {
                while (i > 0 && arr[i - 1] < arr[i])
                {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    i--;
                }
            }
        }
    }

    public static int[] arrayDiff(int[] aOne, int[] aTwo)
    {
        int length = 0;
        insertSort(aTwo, true);
        for (int i = 0; i < aOne.length; i++)
        {
            if (binarySearch(aTwo, aOne[i]) == -1)
            {
                length++;
            }
        }
        int[] newArr = new int[length];
        int index = 0;
        for (int i = 0; i < aOne.length; i++)
        {
            if (binarySearch(aTwo, aOne[i]) == -1)
            {
                newArr[index++] = aOne[i];
            }
        }
        return newArr;
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
        return -1;
    }

    public static int[][] subtractMatrices(int[][] aOne, int[][] aTwo)
    {
        int[][] newArr = new int[aOne.length][];
        for (int i = 0; i < aOne.length; i++)
        {
            newArr[i] = aOne[i];
        }
        for (int i = 0; i < newArr.length; i++)
        {
            for (int j = 0; j < newArr[i].length; j++)
            {
                newArr[i][j] = aOne[i][j] - aTwo[i][j];
            }
        }
        return newArr;
    }

    public static int[] pallPrimeInt()
    {
        int length = 50;
        int[] arr = new int[length];
        int index = 0;
        int number = 2;
        while (index < 50)
        {
            if (isPrime(number) && isPalindromic(number))
            {
                arr[index++] = number;
            }
            number++;
        }
        return arr;
    }

    public static boolean isPrime(int number)
    {
        if (number <= 1) return false;
        else
        {
            for (int i = 2; i <= number / 2; i++)
            {
                if (number % i == 0) return false;
            }
            return true;
        }
    }

    public static boolean isPalindromic(int number)
    {
        String numberStr = number + "";
        int left = 0;
        int right = numberStr.length() - 1;
        while (left <= right)
        {
            if (numberStr.charAt(left) != numberStr.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int[] sumArrayRows(int[][] aTest)
    {
        int length = aTest.length;
        int[] newArr = new int[length];
        for (int i = 0; i < newArr.length; i++)
        {
            newArr[i] = sumSingleRow(aTest[i]);
        }
        return newArr;
    }

    public static int sumSingleRow(int[] arr)
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }
        return sum;
    }

    public static boolean isCons4(char[][] aSample)
    {
        int rows = aSample.length;
        int cols = aSample[0].length;
        for (int i = 0; i <= rows - 4; i++)
        {
            for (int j = 0; j <= cols - 4; j++)
            {
                char[][] temp = cut(aSample, i, j);
                if (checkRows(temp) || checkCols(temp) || checkDiags(temp))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static char[][] cut(char[][] aSample, int startRowIndex, int startColIndex)
    {
        char[][] smallArr = new char[4][4];
        int indexRow = 0;

        for (int i = startRowIndex; i < startRowIndex + 4; i++, indexRow++)
        {
            int indexCol = 0;
            for (int j = startColIndex; j < startColIndex + 4; j++, indexCol++)
            {
                smallArr[indexRow][indexCol] = aSample[i][j];
            }
        }
        return smallArr;
    }

    public static boolean checkRows(char[][] aSample)
    {
        for (int i = 0; i < aSample.length; i++)
        {
            if (checkOneRow(aSample[i]))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean checkOneRow(char[] single)
    {
        return (single[0] == single[1]) && (single[2] == single[3]) && (single[1] == single[2]);
    }

    public static boolean checkCols(char[][] aSample)
    {
        for (int i = 0; i < 4; i++)
        {
            if ((aSample[0][i] == aSample[1][i]) && (aSample[2][i] == aSample[3][i]) && (aSample[1][i] == aSample[2][i]))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiags(char[][] aSample)
    {
        if ((aSample[0][0] == aSample[1][1]) && (aSample[2][2] == aSample[3][3]) && (aSample[1][1] == aSample[2][2]))
        {
            return true;
        }
        if ((aSample[0][3] == aSample[1][2]) && (aSample[2][1] == aSample[3][0]) && (aSample[1][2] == aSample[2][1]))
        {
            return true;
        }
        return false;
    }
}
