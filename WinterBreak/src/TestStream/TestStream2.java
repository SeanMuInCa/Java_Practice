package TestStream;

import org.junit.Test;

import java.util.List;
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
 * 步骤2 一系列中间操作
 */
public class TestStream2
{
    //筛选与切片
    @Test
    public void test1(){
        List<Person> list = PersonData.getPersonList();
        Stream<Person> stream = list.stream();
        stream.filter(person -> person.getAge() > 15).forEach(System.out::println);//foreach是一个终止操作
        System.out.println();

        list.stream().limit(2).forEach(System.out::println);//最多limit几个元素

        System.out.println();
        list.stream().skip(2).forEach(System.out::println);//跳过前几个元素

        System.out.println();

    }
}
