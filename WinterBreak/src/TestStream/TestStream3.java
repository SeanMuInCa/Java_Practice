package TestStream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Purpose:             TestStream<br />
 * Data Submitted:      2024/1/5 <br />
 * Assignment Number:    TestStream<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestStream <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 终止操作
 */
public class TestStream3
{
    //匹配与查找
    @Test
    public void test1(){
        List<Person> list = PersonData.getPersonList();
        System.out.println(list.stream().allMatch(person -> person.getName().startsWith("raina")));

        boolean anyMatch = list.stream().anyMatch(person -> person.getAge() > 20);
        System.out.println(anyMatch);

        Optional<Person> first = list.stream().filter(person -> person.getAge() > 18).findFirst();
        System.out.println(first.get());

        long count = list.stream().filter(person -> person.getAge() > 16).count();
        System.out.println(list.size());
        System.out.println(count);

        System.out.println(list.stream().max((p1, p2) -> p1.getAge() - p2.getAge()).get().getAge());
        System.out.println(list.stream().max((p1, p2) -> p1.getAge() - p2.getAge()).map(p -> p.getAge()).get());
        System.out.println(list.stream().map(Person::getAge).max((a1, a2) -> a1 - a2).get());
        System.out.println(list.stream().min((p1, p2) -> p1.getAge() - p2.getAge()).get());

        //对于list遍历
        //1.iterator
        Iterator<Person> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //2for
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        //3 enhence for
        for (Person p : list){
            System.out.println(p);
        }
        //4for each
        list.forEach(System.out::println);
        //5stream
        list.stream().forEach(System.out::println);
        list.stream().forEach(p -> System.out.println(p));
    }
    //归约 reduce
    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(list.stream().reduce((pre, cur) -> pre + cur).get());
        System.out.println(list.stream().reduce(Integer::sum).get());

        List<Person> list1 = PersonData.getPersonList();
        System.out.println(list1.stream().map(person -> person.getAge()).reduce(0,(pre,cur) -> pre + cur));
        System.out.println(list1.stream().map(Person::getAge).reduce(0,Integer::sum));
    }
    //收集，也就是将流转换为其他形式保存下来。原来的操作都是在内存里实现的，对原始数据没有改变的
    @Test
    public void test3(){
        List<Person> list = PersonData.getPersonList();
        List<Person> collect = list.stream().filter(p -> p.getAge() > 19).collect(Collectors.toList());
        System.out.println(collect.stream().map(p -> p.getAge()).reduce(0, (pre, cur) -> pre + cur));
        collect.forEach(System.out::println);
    }
}
