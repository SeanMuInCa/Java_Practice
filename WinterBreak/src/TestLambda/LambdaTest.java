package TestLambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Purpose:             TestLambda<br />
 * Data Submitted:      2024/1/2 <br />
 * Assignment Number:    TestLambda<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestLambda <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class LambdaTest
{
    @Test
    public void test(){
        Comparator<String> com1 = new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        };
        Comparator<String> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare("a", "b"));
        Comparator<String> com3 = String::compareTo;
        System.out.println(com3.compare("a", "b"));
    }
    @Test
    public void test2(){
        Predicate<String> bi = new Predicate<String>()
        {
            @Override
            public boolean test(String s)
            {
                return s.startsWith("s");
            }
        };
        Predicate<String> b = s -> s.startsWith("s");
        System.out.println(b.test("start"));
        BiPredicate<String,String> bi1 = new BiPredicate<String, String>()
        {
            @Override
            public boolean test(String s1, String s2)
            {
                return s1.equals(s2);
            }
        };
        BiPredicate<String, String> bi2 = (s1, s2) -> s1.equals(s2);
        System.out.println(bi2.test("a", "b"));
        BiPredicate<String, String> bi3 = String::equals;
        System.out.println(bi3.test("a", "b"));
    }
    @Test
    public void test3(){
        Person p = new Person("raina",14,13);
        Function<Person, String> fun1 = new Function<Person, String>()
        {
            @Override
            public String apply(Person person)
            {
                return person.getName();
            }
        };
        Function<Person, String> fun2 = p1 -> p1.getName();
        System.out.println(fun2.apply(p));
        Function<Person, String> fun3 = Person::getName;
        System.out.println(fun3.apply(p));
    }
    @Test
    public void test4(){
        Runnable r1 = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("abc");
            }
        };
        Runnable r2 = () -> System.out.println("hello");
        r2.run();
        r1.run();
    }
    @Test
    public void test5(){
        String[] arr = {"hello", "Hello", "java", "Java"};
        Arrays.sort(arr, String::compareToIgnoreCase);
        Arrays.sort(arr, String::compareToIgnoreCase);
        for (String s : arr){
            System.out.println(s);
        }
    }
    @Test
    public void test6(){
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");

        list.forEach(str -> System.out.println(str));
        list.forEach(System.out::println);
    }
}
