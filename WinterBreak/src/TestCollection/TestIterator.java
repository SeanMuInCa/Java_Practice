package TestCollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

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
public class TestIterator
{
    @Test
    public void test(){
        Collection col = new ArrayList();
        col.add("a");
        col.add("b");
        col.add(1);
        col.add(new Person("zs",19));

        //获取迭代器对象
        Iterator it = col.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

}
