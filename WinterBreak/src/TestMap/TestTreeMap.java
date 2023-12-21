package TestMap;

import org.junit.Test;

import java.util.TreeMap;

/**
 * Purpose:             TestMap<br />
 * Data Submitted:      2023/12/21 <br />
 * Assignment Number:    TestMap<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestMap <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestTreeMap
{
    @Test
    public void test(){
        TreeMap map = new TreeMap<>();

        map.put("cc",89);
        map.put("bb",90);
        map.put("aa",91);
        map.put("dd",92);

        for (Object o : map.entrySet())
        {
            System.out.println(o);//根据key排序
        }

    }
}
