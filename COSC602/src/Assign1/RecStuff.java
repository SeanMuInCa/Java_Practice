package Assign1;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

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
        File file = new File("D:\\test\\a.txt");
        overrideWord(file,sOldWord,sNewWord);
        /*for (File f : file.listFiles()){
            if(f.isDirectory()){
                replaceAll(f.getPath(),sOldWord,sNewWord);
            }else{
                overrideWord(f,sOldWord,sNewWord);
            }
        }*/
    }

    private static void overrideWord(File f, String sOldWord, String sNewWord)
    {
        //todo not solve yet
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try
        {
            fr = new FileReader(f);
            fw = new FileWriter(new File("D:\\test\\fixed.txt"));

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            //方式1
            /*char[] buffer = new char[1024];

            int length;
            while ((length = br.read(buffer)) != -1)
            {//这里返回的是读取的长度
                bw.write(buffer, 0, length);
            }*/
            //方式2
            String data;
            while ((data = br.readLine())!= null)
            {
                data = data.replaceAll(sOldWord, sNewWord);
                bw.write(data);
                bw.newLine();
            }
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

    public static void modifiedMergeSort(int[] arr)
    {
        /*if(arr.length > 80) mergeSort(arr);
        else bubbleSort(arr);*/
        mergeSort(arr);
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
        System.out.println(reverseStr("Hello World"));
        System.out.println(removeLast("The sly moon is high in the sky", new StringBuffer("ken")));
        System.out.println(Bin2Dec("0010 0110"));
        replaceAll("D:\\test","abc","raina");
        int[] arr = {1,2,3,4,5,5,4,2,1,12,23,52,1,54};
        modifiedMergeSort(arr);
        System.out.println(Arrays.toString(arr));

        /*int[] arrL = {1,2};
        int[] arrR = {1,2,3,4};
        int[] arr1 = new int[6];
        merge(arr1,arrL,arrR);
        System.out.println(Arrays.toString(arr1));*/
    }
}
