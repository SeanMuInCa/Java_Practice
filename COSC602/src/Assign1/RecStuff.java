package Assign1;

import java.io.*;
import java.util.Random;

/**
 * Purpose:             Assign1<br />
 * Data Submitted:      2024/1/17 <br />
 * Assignment Number:    Assign1<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Assign1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class RecStuff
{
    public static String reverseStr(String sVal)
    {
        /*String temp = "";
        if (sVal.length() == 1) return sVal.charAt(0) + temp;
        else
        {
            temp = temp.concat(sVal.charAt(sVal.length() - 1) + reverseStr(sVal.substring(0, sVal.length() - 1)));
            return temp;
        }*/
        if (sVal.length() <= 1) return sVal;
        return reverseStr(sVal.substring(1)) + sVal.charAt(0);
    }

    public static String removeLast(String sPhrase, StringBuffer sKey)
    {
        if (sKey.isEmpty()) return sPhrase;

        char singleKey = sKey.charAt(sKey.length() - 1);
        int index = sPhrase.lastIndexOf(singleKey);
        if (index == -1) return sPhrase;

        String newStr = sPhrase.substring(0, index) + sPhrase.substring(index + 1);

        sKey.deleteCharAt(sKey.length() - 1);//can not use 0, otherwise it won't go recursive

        return removeLast(newStr, sKey);
    }

    public static int Bin2Dec(String sBinNumber)
    {
        sBinNumber = sBinNumber.replaceAll(" ","");
        if(sBinNumber.isEmpty()) return 0;
        else {
            int res = 0;
            if (sBinNumber.charAt(0) == '1')
            {
                res += (int) Math.pow(2, sBinNumber.length() - 1);
            } else
            {
                res += 0;
            }
            res += Bin2Dec(sBinNumber.substring(1));
            return res;
        }
    }

    public static void replaceAll(String sPath, String sOldWord, String sNewWord)
    {
        File file = new File(sPath);
        for (File f : file.listFiles()){
            if(f.isDirectory()){
                replaceAll(f.getPath(),sOldWord,sNewWord);
            }else{
                if(f.getName().endsWith("txt"))
                    overrideWord(f,sOldWord,sNewWord);
            }
        }
    }

    private static void overrideWord(File f, String sOldWord, String sNewWord)
    {
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try
        {

            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String oneLineData;
            String res = "";
            while ((oneLineData = br.readLine())!= null)
            {
                res = res.concat(oneLineData + "\n");
            }
            br.close();
            res = res.replaceAll(sOldWord,sNewWord);
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            bw.write(res);
            bw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * as my test methods below, i use four sizes of array to test both mergeSort
     * same computer same test methods.
     * Here is what I learn from the results:
     * Our new merge sort method is more efficient when the size is less than 1,000,000,
     * and it's very clear. after 1,000,000 size, they both seems not much different in this size.
     *  Here is the data:
     * new method:
     * The 10,000 size arr execution times is 1,321,300 nano seconds
     * The 100,000 size arr execution times is 9,722,100 nano seconds
     * The 1,000,000 size arr execution times is 107,892,400 nano seconds
     * The 10,000,000 size arr execution times is 1,096,443,500 nano seconds
     *
     * old method:
     * The 10,000 size arr execution times is 1,429,800 nano seconds
     * The 100,000 size arr execution times is 10,311,300 nano seconds
     * The 1,000,000 size arr execution times is 102,378,000 nano seconds
     * The 10,000,000 size arr execution times is 1,057,083,000 nano seconds
     * @param arr
     */
    public static void modifiedMergeSort(int[] arr)
    {
        if(arr.length > 80) mergeSort(arr);
        else bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr)
    {
        for (int i = arr.length - 1; i > 0; i--)
        {
            boolean sorted = true;
            for (int j = 0; j < i; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    swap(arr, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }
    private static void swap(int[] arr, int highPos, int right)
    {
        int temp = arr[highPos];
        arr[highPos] = arr[right];
        arr[right] = temp;
    }
    private static void mergeSort(int[] arr)
    {
        //base case
        if(arr.length <= 1) return;

        int mid = arr.length / 2;

        int[] leftPart = new int[mid];
        int[] rightPart = new int[arr.length - mid];

        System.arraycopy(arr,0,leftPart,0,mid);
        System.arraycopy(arr,mid,rightPart,0,arr.length - mid);

        mergeSort(leftPart);
        mergeSort(rightPart);

        merge(arr, leftPart, rightPart);
    }

    private static void merge(int[] arr, int[] leftPart, int[] rightPart)
    {
        int i = 0, j = 0,k=0;
        for (; (i < leftPart.length && j < rightPart.length); )
        {
            if(leftPart[i] < rightPart[j]){
                arr[k] = leftPart[i];
                i++;
            }else {
                arr[k] = rightPart[j];
                j++;
            }
            k++;
        }
        if(i < leftPart.length){
            for (;i < leftPart.length;i++){
                arr[k] = leftPart[i];
                k++;
            }
        }
        if(j < rightPart.length){
            for (;j < rightPart.length;j++){
                arr[k] = rightPart[j];
                k++;
            }
        }
    }


    public static void main(String[] args)
    {
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
        modifiedMergeSort(arr);
        long end = System.nanoTime();
        System.out.println("The " + size + " size arr execution times is " + (end - start) + " nano seconds");
    }
}
