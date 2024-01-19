package Assign1;

import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * Purpose:             Assign1<br />
 * Data Submitted:      2024/1/18 <br />
 * Assignment Number:    Assign1<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Assign1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestFile
{
    @Test
    public void test(){
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try
        {
            File file1 = new File("d:\\Java\\test.txt");
            fr = new FileReader(file1);

            File file2 = new File("d:\\Java\\res_copy1.txt");
            fw = new FileWriter(file2);

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);


            String data;
            String res = "";
            while ((data = br.readLine())!= null)
            {
                res = res.concat(data + "\n");
            }
            System.out.println(res);
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (br != null)
                    br.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if (bw != null)
                    bw.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test2(){
        int arraySize1 = 10000;
        int arraySize2 = 100000;
        int arraySize3 = 1000000;
        int arraySize4 = 10000000;
        int[] arr1 = generateRandomArray(arraySize1);
        int[] arr2 = generateRandomArray(arraySize2);
        int[] arr3 = generateRandomArray(arraySize3);
        int[] arr4 = generateRandomArray(arraySize4);
        displayTime(arr1,arraySize1);
        displayTime(arr2,arraySize2);
        displayTime(arr3,arraySize3);
        displayTime(arr4,arraySize4);
    }
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }

        return array;
    }
    private static void displayTime(int[] arr, int size){
        long start = System.nanoTime();
        mergeSort(arr);
        long end = System.nanoTime();
        System.out.println("The " + size + " size arr execution times is " + (end - start) + " nano seconds");
    }
    public static void mergeSort(int[] arr)
    {
        mergeSort(arr,0,arr.length - 1);
    }

    private static void mergeSort(int[] arr, int low, int high)
    {
        if(high - low <= 0) return;
        int mid = (low + high) / 2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid + 1, high);
        mergeE(arr,low,mid,high);
    }

    public static void mergeE(int []arr, int low, int mid, int high)
    {
        int wLen = mid-low+1;
        int hLen = high-mid;
        int []left = new int[wLen];
        int []right;
        if (hLen > 0)
            right= new int[hLen];
        else
            right=null;

        for(int i=0; i<wLen; i++)
        {
            left[i] = arr[low+i]; //Copy left array
        }

        for(int j=0; j<hLen; j++)
        {
            right[j] = arr[mid+1+j]; //Copy right array
        }

        int i=0, j=0, k=low;

        //Merge left and right arrays
        while(i<wLen && j<hLen)
        {
            if(left[i]<=right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }

            k++;
        }

        while(i<wLen) {
            arr[k++] = left[i++];
        }

        while(j<hLen)
        {
            arr[k++] = right[j++];
        }
    }
}
