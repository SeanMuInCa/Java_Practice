package TestStream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Purpose:             TestStream<br />
 * Data Submitted:      2024/2/12 <br />
 * Assignment Number:    TestStream<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestStream <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestStream5
{
    //中间方法
    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("raina");
        list.add("rainba");
        list.add("rainma");
        list.add("flily");

        //filter
        list.stream().filter(s -> s.startsWith("r")).forEach(System.out::println);
        System.out.println();
        list.forEach(System.out::println);
        System.out.println();
        //limit
        list.stream().limit(1).forEach(System.out::println);
        System.out.println();
        //skip
        list.stream().skip(2).forEach(System.out::println);
        System.out.println();
        //distinct去重
        list.add("raina");
        System.out.println(list);
        list.stream().distinct().forEach(System.out::println);
        System.out.println();
        //concat
        Stream.concat(list.stream(), List.of("aa", "bb", "cc").stream()).forEach(System.out::println);
    }
    //终结方法
    @Test
    public void test1(){

    }
}
