package TestCollection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
}
