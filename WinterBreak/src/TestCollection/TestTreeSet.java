package TestCollection;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

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
 */
public class TestTreeSet
{
    @Test
    public void test(){//treeset是基于红黑树，因此要比较大小，所以只能是同一个类型，如果要加对象，需要comparable
        TreeSet<Integer> set = new TreeSet<>();
        set.add(23);
        set.add(12);
        set.add(123);
//        set.add(new Person("raina",14));
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
