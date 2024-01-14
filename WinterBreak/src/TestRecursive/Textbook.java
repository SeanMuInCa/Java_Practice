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
    public void test1(){
        printMSG(5,"hello");
        System.out.println(isPalindromes("daaad"));
        int[] arr = new int[]{4,2,2,5,15,11,62,4,6};
        recSelectionSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(recBinarySearch(arr, 11));
    }
    public void printMSG(int times, String msg){
        if(times == 1) System.out.println(msg);
        else {
            System.out.println(msg);
            printMSG(times - 1, msg);
        }
    }
    public boolean isPalindromes(String str){
        if(str.length() <= 1) return true; //base case
        else if(str.charAt(0) != str.charAt(str.length() - 1)) return false;//base case
        else return isPalindromes(str.substring(1,str.length() - 1));
    }
    public void recSelectionSort(int[] arr){
        recSelectionSort(arr,0,arr.length - 1);
    }

    private void recSelectionSort(int[] arr, int low, int high)
    {
        if(low < high){
            //find the smallest number and index
            int indexOfMin = low;
            int min = arr[indexOfMin];
            for (int i = low + 1; i <= high ; i++)
            {
                if(arr[i] < min){
                    min = arr[i];
                    indexOfMin = i;
                }
            }
            //swap the smallest in arr with arr[low]
            arr[indexOfMin] = arr[low];
            arr[low] = min;
            //sort the rest
            recSelectionSort(arr,low + 1, high);
        }
    }
    public int recBinarySearch(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        return recBinarySearch(arr,key,left,right);
    }

    private int recBinarySearch(int[] arr, int key, int left, int right)
    {
        if(left > right) return - left - 1;
        int mid = (left + right) / 2;
        if(key < arr[mid]) return recBinarySearch(arr,key, 0, mid - 1);
        else if (key == arr[mid]) return mid;
        else return recBinarySearch(arr,key,mid + 1, right);
    }
    @Test
    public void test2(){
        File file = new File("d:\\Java");
        System.out.println(getSize(file) + " Bytes");
    }
    public long getSize(File file){
        long size = 0;
        if(file.isDirectory()){// recursive call
            File[] files = file.listFiles();
            for(File f : files){
                size += getSize(f);
            }
        }else{
            size += file.length(); //base case
        }
        return size;
    }
    @Test
    public void test3(){
        //hanoi
        hanoi(3,'A','B','C');
    }
    public void hanoi(int n, char fromTower, char auxTower, char targetTower){
        if(n == 1){
            System.out.println("Move disk " + n + " from " + fromTower + " to " + targetTower);
        }else{
            hanoi(n - 1, fromTower, targetTower, auxTower);
            System.out.println("Move disk " + n + " from " + fromTower + " to " + targetTower);
            hanoi(n - 1, auxTower, fromTower, targetTower);
        }
    }
}
