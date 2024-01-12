package TestLambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

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
}
