package mashibing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Purpose:             To output sum of two integers. <br />
 * To use run the main method. <br />
 * Data Submitted:      2023/11/12 <br />
 * Assignment Number:   Lab 1  <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing <br />
 *
 * @author Zhenghua Mu (instructor - no SDC#)
 * @version 1.0.0
 */
public class TestCollection
{
    public static void main(String[] args)
    {
        ArrayList list = new ArrayList();
        int[] arr = new int[]{1, 2, 3};
        list.add(123);
        list.add(0);
        list.add(arr);
        System.out.println(list);
        ArrayList list1 = new ArrayList();
        list1.add(true);
        list1.addAll(list);
        System.out.println(list1+"@@@");
        System.out.println(list.size());
        System.out.println(list1.size());
//        list.clear();
//        list1.remove(123);
        list.remove(arr);
//        System.out.println(list.remove(0));
//        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
//        System.out.println(list1.isEmpty());
//        System.out.println(list1.size());
//        System.out.println(list.contains(arr));
//        System.out.println(list1.contains(arr));
//        System.out.println(list1.iterator());
        System.out.println(list);
        System.out.println(list1);
        ArrayList list2 = new ArrayList();
        list2.addAll(list);
        System.out.println(list2);
        System.out.println(list2.equals(list));
        Iterator it = list1.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        for (Object o :list){
            System.out.println(o);
        }
        System.out.println(list2);
        Collections.sort(list2);
        System.out.println(list2);
        String[] array = {"red", "green", "blue"};
        ArrayList list3 = new ArrayList(Arrays.asList(array));
        Double[] arr2 = {1.2,2.2,3.2};
        ArrayList list4 = new ArrayList(Arrays.asList(arr2));
        System.out.println(list3);
        System.out.println(list4);
        Integer[] array2 = {3, 5, 95, 4, 15, 34, 3, 6, 5};
        ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(array2));
        System.out.println(list5);
        java.util.Collections.sort(list5);
        System.out.println(list5);
    }
}
