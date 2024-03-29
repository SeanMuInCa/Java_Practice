package TestLambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Purpose:             TestLambda<br />
 * Data Submitted:      2024/1/11 <br />
 * Assignment Number:    TestLambda<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestLambda <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestLambda
{
    List<Person> list = new ArrayList<>();
    @Test
    public void test1(){
        new Comparator<Person>(){

            @Override
            public int compare(Person o1, Person o2)
            {
                return o1.getAge() - o2.getAge();
            }
        };

        Comparator<Person> com = (o1,o2) -> o1.getAge() - o2.getAge();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("new thread1");
            }
        }).start();

        new Thread(() -> System.out.println("new thread2")).start();
        list.add(new Person("raina",14,1));
        list.add(new Person("raina1",15,2));
        list.add(new Person("raina2",16,3));
        list.add(new Person("raina3",17,4));
        filter1(list, raina -> raina.getAge() > 15);
    }

    @Test
    public void test2(){
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }
        System.out.println("-----------------------");
        features.forEach(str -> System.out.println(str));
        System.out.println("-----------------------");
        features.forEach(System.out::println);
    }
    @Test
    public void test3(){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        filter(languages,str -> (str).startsWith("J"));
        filter(languages,str -> (str).length() > 5);
        System.out.println("----------------");
        Predicate<String> p1 = str -> str.startsWith("J");
        Predicate<String> p2 = str -> str.length() > 3;
        languages.stream().filter(p1.or(p2)).forEach(System.out::println);
    }
    public static void filter(List<String> names, Predicate<String> condition) {
        for(String  name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }
    public static void filter1(List<Person> ps, Predicate<Person> condition) {
        for(Person p1: ps)  {
            if(condition.test(p1)) {
                System.out.println(p1 + " ");
            }
        }
    }
    @Test
    public void test4(){
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);

        costBeforeTax.stream().map(cost -> cost * .11 + cost).forEach(System.out::println);

        Double total = costBeforeTax.stream().map(cost -> cost * .11 + cost).reduce((pre, cur) -> pre + cur).get();
        System.out.println(total);

        List<String> strList = Arrays.asList("Java","C++","C", "C#", "PHP");
        // 创建一个字符串列表，每个字符串长度大于2
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }
    @Test
    public void test5(){
        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        List<String> G7Countries = G7.stream().map(str -> str + "!").toList();
        G7Countries.forEach(str -> System.out.print(str + " "));

        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }
    @Test
    public void test6(){
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }
}
