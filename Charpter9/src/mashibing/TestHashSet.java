package mashibing;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Purpose:             mashibing<br />
 * Data Submitted:      2023/11/21 <br />
 * Assignment Number:    mashibing<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestHashSet
{
    public static void main(String[] args)
    {
        int[] arr= {1,2,4,5,6,23,2};
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        Object[] arr1 = hs.toArray();
        System.out.println(hs);
        System.out.println(Arrays.toString(arr1));
        System.out.println(arr1[0]);
        System.out.println("----------------");
        HashSet<String> hs1 = new HashSet<>();
        hs1.add("i");
        hs1.add("love");
        hs1.add(new String("java"));
        hs1.add(new String("java"));
        System.out.println(hs1);
        System.out.println();
        System.out.println(Integer.hashCode(5));
        System.out.println("java".hashCode());
        System.out.println(new String("java").hashCode());
        System.out.println(hs1.hashCode());
    }
}
