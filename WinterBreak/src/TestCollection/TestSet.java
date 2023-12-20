package TestCollection;

import org.junit.Test;

import java.util.*;

/**
 * Purpose:             TestCollection<br />
 * Data Submitted:      2023/12/20 <br />
 * Assignment Number:    TestCollection<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestCollection <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * set实际是map的一种实现，set中的元素是无序的，并且不允许重复的元素。
 */
public class TestSet
{
    @Test
    public void test(){
        Set set = new HashSet();
        set.add("aa");
        set.add("bb");
        set.add(123);
        set.add(new Student("raina",14));
        set.add(new Person("raina",14));

        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test
    public void test1(){
        List list = new ArrayList<>();
        list.add("aa");
        list.add("aa");
        list.add("aa");
        list.add("aa");
        list.add("bb");
        list.add(3);
        list.add(new Person("w5",21));
        System.out.println(list);
        Set set = new HashSet<>(list);
        System.out.println(set);
        list = new ArrayList<>(set);
        System.out.println(list);
    }
}
