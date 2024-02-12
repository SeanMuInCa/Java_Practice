package TestStream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose:             TestStream<br />
 * Data Submitted:      2024/2/11 <br />
 * Assignment Number:    TestStream<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestStream <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestStream4
{
    @Test
    public void test1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("raina");
        list.add("rainma");
        list.add("rainba");
        list.add("realraina1");
        list.add("realraina2");
        list.add("realraina3");

        List<String> rain = list.stream().filter(s -> s.startsWith("rain")).toList();
        for (String s : rain)
        {
            System.out.println(s);
        }
        System.out.println();
        List<String> rain1 = list.stream().filter(s -> s.startsWith("r") && s.length() > 5).toList();
        for (String s : rain1)
        {
            System.out.println(s);
        }
    }
}
