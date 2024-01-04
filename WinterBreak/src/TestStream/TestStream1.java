package TestStream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Purpose:             TestStream<br />
 * Data Submitted:      2024/1/4 <br />
 * Assignment Number:    TestStream<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestStream <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestStream1
{
    //创建stream方式1，通过集合
    @Test
    public void test1(){
        List<Person> list = PersonData.getPersonList();
        Stream<Person> stream = list.stream();//顺序流

        Stream<Person> personStream = list.parallelStream();//并行流
    }
    //创建stream方式2，通过数组
    @Test
    public void test2(){
        Integer[] arr = new Integer[]{1,2,3,4,5};
        Stream<Integer> stream = Arrays.stream(arr);

        int[] arr1 = new int[]{1,2,3,4,5};
        IntStream stream1 = Arrays.stream(arr1);//IntStream
    }
    //创建stream方式3，通过Stream 的of()方法
    @Test
    public void test3(){
        Stream<String> stringStream = Stream.of("a", "b", "c");
    }
}
