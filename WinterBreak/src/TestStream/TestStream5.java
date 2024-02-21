package TestStream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
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
    public void test()
    {
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
        //distinct去重 这个是依赖hash和equals所以要重写这两个方法
        list.add("raina");
        System.out.println(list);
        list.stream().distinct().forEach(System.out::println);
        System.out.println();
        //concat
        Stream.concat(list.stream(), Stream.of("aa", "bb", "cc")).forEach(System.out::println);

        //map
        List<String> list2 = new ArrayList<>();
        list2.add("raina-14");
        list2.add("rainma-39");
        list2.add("rainba-42");
        list2.add("flily-5");
        System.out.println();
        list2.stream().map(s -> s.split("-")).map(strings -> Integer.parseInt(strings[1])).forEach(System.out::println);
    }

    //终结方法
    @Test
    public void test1()
    {
        //foreach count toArray
        List<String> list = new ArrayList<>();
        list.add("raina");
        list.add("rainba");
        list.add("rainma");
        list.add("flily");

        System.out.println(list.stream().count());
        System.out.println();
        /*list.stream().toArray(new IntFunction<String[]>()
        {
            @Override
            public String[] apply(int value)
            {
                return new String[value];
            }
        });*/
        String[] array = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2()
    {
        //collect 收集到list,map,set里
        List<String> list = new ArrayList<>();
        list.add("raina-female-14");
        list.add("rainba-male-42");
        list.add("rainma-female-39");
        list.add("flily-female-5");

        System.out.println(list.stream().distinct().count());
        //收集到list
        list.stream().filter(s->s.split("-")[1].equals("female")).forEach(System.out::println);
        List<String> list1 = list.stream().filter(s -> s.split("-")[1].equals("female")).collect(Collectors.toList());
        System.out.println(list1);

        System.out.println();
        //收集到set
        Set<String> list2 = list.stream().filter(s -> Integer.parseInt(s.split("-")[2]) < 15).collect(Collectors.toSet());
        System.out.println(list2);

        //收集到map
        Map<String, Integer> list3 = list.stream().filter(s -> s.split("-")[1].equals("female"))
                .collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[2])));
        list3.forEach((k,v) ->{
            System.out.print(k + "---->" + v);
            System.out.println();
        });
    }
}
