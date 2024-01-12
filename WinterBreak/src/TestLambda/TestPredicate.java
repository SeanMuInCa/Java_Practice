package TestLambda;

import org.junit.Test;

import java.util.ArrayList;

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
public class TestPredicate
{
    @Test
    public void test1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("java");
        list.add("polo");
        list.add("ok");

        System.out.println(null == null);

        // forEach
        list.forEach(System.out::println);

        // removeIf
        list.removeIf(s -> containsIgnoreCase(s, "o"));

        System.out.println("---------------");
        // forEach
        list.forEach(System.out::println);
    }

    private boolean containsIgnoreCase(String str, String target)
    {
        return str.toLowerCase().contains(target.toLowerCase());
    }
}
