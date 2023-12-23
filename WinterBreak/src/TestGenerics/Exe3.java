package TestGenerics;

import org.junit.Test;

import java.util.*;

/**
 * Purpose:             TestGenerics<br />
 * Data Submitted:      2023/12/22 <br />
 * Assignment Number:    TestGenerics<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestGenerics <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Exe3
{
    public static <E> void method1(E[] e, int a ,int b){//swap
        E temp = e[a];
        e[a] = e[b];
        e[b] = temp;
    }
    public static <E> void method2(E[] e){//reverse
        List<E> list = Arrays.asList(e);
        Collections.reverse(list);
        list.toArray(e);
    }
    @Test
    public void test(){
        Integer[] arr = {1,2,3,4,5};//这里不能是int数组了
        method1(arr,0,1);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        Integer[] arr = {2,3,1,5,4};
        method2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
