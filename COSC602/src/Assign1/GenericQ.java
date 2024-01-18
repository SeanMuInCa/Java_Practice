package Assign1;

import org.testng.annotations.Test;

import java.util.*;

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
public class GenericQ
{
    public static <E> E[] removeDuplicates(E[] aVals)
    {
        int count = 0;
        for (int i = 0; i < aVals.length; i++)
        {
            for (int j = i + 1; j < aVals.length; j++)
            {
                if (aVals[i].equals(aVals[j]))
                {
                    count++;
                    break;
                }
            }
        }
        E[] array = (E[]) new Object[aVals.length - count];
        Arrays.sort(aVals);
        array[0] = aVals[0];
        for (int i = 1; i < array.length; i++)
        {
            for (int j = 1; j < aVals.length; j++)
            {
                if (array[i].equals(aVals[j])) break;
            }
        }
        return array;
    }

    @Test
    public void test1()
    {
        Integer[] arr = {1, 1, 3, 1};
        String[] arr1 = {"aa", "bb", "cc", "aa"};
        System.out.println(Arrays.toString(removeDuplicates(arr)));
    }

    public static <T extends Comparable<T>> T getSmallest(List<T> list)
    {
        Iterator<T> iterator = list.iterator();
        T min = iterator.next();
        while (iterator.hasNext())
        {
            T next = iterator.next();
            if (min.compareTo(next) > 0)
                min = next;
        }
        return min;
    }
    @org.junit.Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(55);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(34);
        System.out.println(getSmallest(list));
    }
}
