package TestLambda;

import org.junit.Test;

import java.util.ArrayList;
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
}
