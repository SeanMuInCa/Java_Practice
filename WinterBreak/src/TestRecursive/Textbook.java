package TestRecursive;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * Purpose:             TestRecursive<br />
 * Data Submitted:      2024/1/14 <br />
 * Assignment Number:    TestRecursive<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestRecursive <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Textbook
{
    @Test
    public void test1()
    {
        printMSG(5, "hello");
        System.out.println(isPalindromes("daaad"));
        int[] arr = new int[]{4, 2, 2, 5, 15, 11, 62, 4, 6};
        recSelectionSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(recBinarySearch(arr, 11));
    }

    /**
     * 递归打印多少次消息
     *
     * @param times 次数
     * @param msg   字符串
     */
    public void printMSG(int times, String msg)
    {
        if (times == 1) System.out.println(msg);
        else
        {
            System.out.println(msg);
            printMSG(times - 1, msg);
        }
    }

    //递归判断是否是回文
    public boolean isPalindromes(String str)
    {
        if (str.length() <= 1) return true; //base case
        else if (str.charAt(0) != str.charAt(str.length() - 1)) return false;//base case
        else return isPalindromes(str.substring(1, str.length() - 1));
    }

    public void recSelectionSort(int[] arr)
    {
        recSelectionSort(arr, 0, arr.length - 1);
    }

    private void recSelectionSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            //find the smallest number and index
            int indexOfMin = low;
            int min = arr[indexOfMin];
            for (int i = low + 1; i <= high; i++)
            {
                if (arr[i] < min)
                {
                    min = arr[i];
                    indexOfMin = i;
                }
            }
            //swap the smallest in arr with arr[low]
            arr[indexOfMin] = arr[low];
            arr[low] = min;
            //sort the rest
            recSelectionSort(arr, low + 1, high);
        }
    }

    public int recBinarySearch(int[] arr, int key)
    {
        int left = 0;
        int right = arr.length - 1;
        return recBinarySearch(arr, key, left, right);
    }

    private int recBinarySearch(int[] arr, int key, int left, int right)
    {
        if (left > right) return -left - 1;
        int mid = (left + right) / 2;
        if (key < arr[mid]) return recBinarySearch(arr, key, 0, mid - 1);
        else if (key == arr[mid]) return mid;
        else return recBinarySearch(arr, key, mid + 1, right);
    }

    @Test
    public void test2()
    {
        File file = new File("d:\\Java");
        System.out.println(getSize(file) + " Bytes");
        System.out.println(getCount(file) + " files");
    }

    /**
     * 文件夹大小
     *
     * @param file 文件夹
     * @return 文件夹大小
     */
    public long getSize(File file)
    {
        long size = 0;
        if (file.isDirectory())
        {// recursive call
            File[] files = file.listFiles();
            for (File f : files)
            {
                size += getSize(f);
            }
        } else
        {
            size += file.length(); //base case
        }
        return size;
    }

    /**
     * 文件数
     *
     * @param file 文件夹
     * @return 文件夹文件数量
     */
    public int getCount(File file)
    {
        int count = 0;
        if (file.isDirectory())
        {
            for (File listFile : file.listFiles())
            {
                count += getCount(listFile);
            }
        } else
        {
            count++;
        }
        return count;
    }

    @Test
    public void test3()
    {
        //hanoi
        hanoi(4, 'A', 'B', 'C');
    }

    public void hanoi(int n, char fromTower, char auxTower, char targetTower)
    {
        if (n == 1)
        {
            System.out.println("Move disk " + n + " from " + fromTower + " to " + targetTower);
        } else
        {
            hanoi(n - 1, fromTower, targetTower, auxTower);
            System.out.println("Move disk " + n + " from " + fromTower + " to " + targetTower);
            hanoi(n - 1, auxTower, fromTower, targetTower);
        }
    }

    @Test
    public void test4()
    {
        System.out.println(factorial(5));
        System.out.println(tailRecFactorial(5));
    }

    public int factorial(int n)
    {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public int tailRecFactorial(int n)
    {
        return tailRecFactorial(n, 1);
    }

    private int tailRecFactorial(int n, int res)
    {
        if (n == 1) return res;
        return tailRecFactorial(n - 1, res * n);
    }

    @Test
    public void test5()
    {
        int n = 7;
        System.out.println(fib(n));
        System.out.println(tailRecFib(n));
    }

    public int fib(int n)
    {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public int tailRecFib(int n)
    {
        return tailRecFib(n, 0, 1);
    }

    private int tailRecFib(int n, int result, int next)
    {
        if (n == 0) return result;
        return tailRecFib(n - 1, next, result + next);
    }

    @Test
    public void test()
    {
        System.out.println(pow(2, 8));
    }

    /**
     * x的y次方
     *
     * @param x 底数
     * @param y 指数
     * @return 结果
     */
    public static int pow(int x, int y)
    {
        if (x == 0 || x == 1) return x;
        if (y > 1)
        {
            int b = y / 2;
            int a = x * x;
            if (y % 2 == 1)//odd
            {
                return pow(a, b) * x;
            } else return pow(a, b);//even
        } else if (y == 0)
        {
            return 1;
        } else return x;//y==1
    }

    /**
     * 删除非空目录
     *
     * @param dir file对象
     */
    public static void deleteDir(File dir)
    {
        if (dir != null && dir.isDirectory())
        {
            File[] files = dir.listFiles();
            for (File f : files)
            {
                deleteDir(f);
            }
        }
        dir.delete();
    }

    public static void printDigits(int num)
    {
        if (num < 10)
            System.out.print(num + " ");
        else
        {
            printDigits(num / 10);
            System.out.print(num % 10 + " ");
        }
    }

    @Test
    public void test6()
    {
        printDigits(1234);
    }


    public static void main(String[] args)
    {
        int decimal = 38;
        String binary = decimalToBinary(decimal);
        System.out.println("Decimal " + decimal + " is binary " + binary);
    }

    public static String decimalToBinary(int decimal)
    {
        if (decimal == 0)
        {
            return "0";
        } else if (decimal == 1)
        {
            return "1";
        } else
        {
            int remainder = decimal % 2;
            int quotient = decimal / 2;
            return decimalToBinary(quotient) + remainder;
        }
    }


}
