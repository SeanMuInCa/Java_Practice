package TestStream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        list.add(new Person("raina", 14,10));
        Stream<Person> stream = list.stream();
        stream.filter(person -> person.getAge() > 15).forEach(System.out::println);//foreach是一个终止操作
        System.out.println();

        list.stream().limit(2).forEach(System.out::println);//最多limit几个元素

        System.out.println();
        list.stream().skip(2).forEach(System.out::println);//跳过前几个元素

        System.out.println();
        list.add(new Person("raina", 14,10));
        list.add(new Person("raina", 14,10));
        list.add(new Person("raina", 14,10));
        System.out.println(list);
        System.out.println();
        list.stream().distinct().forEach(System.out::println);//去重按照Hashcode和equals去重
    }
    //映射与归约
    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        List<Person> list1 = PersonData.getPersonList();
        list1.stream().filter(person -> person.getName().startsWith("raina")).forEach(System.out::println);
        list1.stream().filter(person -> person.getName().startsWith("raina")).map(Person::getName).forEach(System.out::println);
    }
    //排序
    @Test
    public void test3(){
        Integer[] arr = new Integer[]{88,23,12,34,56,78};//stream不会改变这个原数组
        String[] arr1 = new String[]{"bb","dd","aa","cc","ee","ff"};

        Arrays.stream(arr).sorted().forEach(System.out::println);

        Comparator<Integer> com = (i1, i2) -> i2 - i1;
        Arrays.stream(arr).sorted(com).forEach(System.out::println);
        Comparator<String> comparator = (o1, o2) -> -o1.compareTo(o2);
//        Comparator<String> comparator = String::compareTo;
        Arrays.stream(arr1).sorted(comparator).forEach(System.out::println);

        List<Person> list = PersonData.getPersonList();
        Comparator<Person> com2 = (p1, p2) -> p1.getAge() - p2.getAge();
        list.stream().sorted(com2).forEach(System.out::println);
    }
}
