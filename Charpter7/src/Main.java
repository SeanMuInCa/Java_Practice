public class Main
{
    public static void main(String[] args)
    {
//        int[] arr = {1,2,3};
//        char[] name = {'a','b','c'};
//        int[] myList = new int[10];

//        for (int i = 0; i < myList.length; i++)
//        {
//            myList[i] = i*2;
//            System.out.println(myList[i]);
//        }
//        myList = new int[20];
//        printArray(myList);
//        System.out.println(myList[myList.length - 1]);
//        System.out.println(arr[0]);
//        System.out.println(name);
//        System.out.println("Hello world!");
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int i = BinarySearch.binarySearch(list, 2); // Returns 0
        int j = BinarySearch.binarySearch(list, 11); // Returns 4
        int k = BinarySearch.binarySearch(list, 12); // Returns –6
        int l = BinarySearch.binarySearch(list, 1); // Returns –1
        int m = BinarySearch.binarySearch(list, 3); // Returns –2
        System.out.println(i);
        System.out.println(j);
        System.out.println("k= "+k);
        System.out.println(l);
        System.out.println(m);
        int[] newList ={2, 9, 5, 4, 8, 1, 6};
//        SelectionSort.selectionSort(newList);
        java.util.Arrays.parallelSort(newList);
        java.util.Arrays.fill(newList,0,3,-1);
//        printArray(newList);
        System.out.println(java.util.Arrays.toString(newList));
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}