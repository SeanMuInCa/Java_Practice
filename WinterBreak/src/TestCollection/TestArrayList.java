package TestCollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Purpose:             TestCollection<br />
 * Data Submitted:      2023/12/19 <br />
 * Assignment Number:    TestCollection<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestCollection <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestArrayList
{
    @Test
    public void test(){
        List list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add(3);
        list.add(new Person("w5",21));
        System.out.println(list);
        // add(int index,Object element)
        list.add(2,"cc");
        System.out.println(list);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list.addAll(2,list1);
        System.out.println(list);

        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}