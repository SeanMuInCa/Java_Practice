package TestStream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Purpose:             TestStream<br />
 * Data Submitted:      2024/2/13 <br />
 * Assignment Number:    TestStream<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestStream <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Practice2
{
    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("raina 14");
        list.add("rainba 42");
        list.add("rainma 39");
        list.add("flily 5");
        //大于十岁的组成一个map
        Map<String, Integer> collect = list.stream()
                .filter(s -> Integer.parseInt(s.split(" ")[1]) > 10)
                .collect(Collectors.toMap(s -> s.split(" ")[0],
                        s -> Integer.parseInt(s.split(" ")[1])));
        System.out.println(collect);
    }
}
