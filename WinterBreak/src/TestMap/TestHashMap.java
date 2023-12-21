package TestMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Purpose:             TestMap<br />
 * Data Submitted:      2023/12/20 <br />
 * Assignment Number:    TestMap<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestMap <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestHashMap
{
    @Test
    public void test(){
        Map map = new HashMap<>();
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            map.put(i,arr[i]);
        }
        System.out.println(map);
        /*Object remove = map.remove(0);
        System.out.println(remove);*/
        map.entrySet().forEach(System.out::println);
        map.keySet().forEach(System.out::println);
        map.values().forEach(System.out::println);
    }
}
