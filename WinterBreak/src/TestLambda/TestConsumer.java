package TestLambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Purpose:             TestLambda<br />
 * Data Submitted:      2024/1/10 <br />
 * Assignment Number:    TestLambda<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestLambda <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestConsumer
{
    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("c");
        list.add("C#");
        list.forEach(str -> System.out.println(str));
        list.forEach(System.out::println);
    }
    @Test
    public void test2(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("no.1", 1);
        map.put("no.2", 2);
        map.put("no.3", 3);
        map.put("no.4", 4);

        map.forEach((key,value) -> System.out.println(key + " ---> " + value));
    }
}
