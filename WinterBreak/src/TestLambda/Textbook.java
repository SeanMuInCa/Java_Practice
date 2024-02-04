package TestLambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Purpose:             TestLambda<br />
 * Data Submitted:      2024/2/4 <br />
 * Assignment Number:    TestLambda<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestLambda <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Textbook
{
    @Test
    public void test1(){
        Comparator c = new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                return 0;
            }
        };
        Comparator c1 = (o1,o2) -> 0;
    }
    @Test
    public void test2(){
        Consumer c = new Consumer()
        {
            @Override
            public void accept(Object o)
            {
                System.out.println(o);
            }
        };
        Consumer c1 = o -> System.out.println(o);

        Consumer c2 = System.out::println;
    }
    @Test
    public void test3(){
        Function<Integer,Integer> f = new Function<Integer, Integer>()
        {
            @Override
            public Integer apply(Integer integer)
            {
                return integer * 2;
            }
        };

        Function<Integer,Integer> f1 = i -> i * 2;

        BiFunction<Integer,Integer,Integer> f2 = new BiFunction<Integer, Integer, Integer>()
        {
            @Override
            public Integer apply(Integer integer, Integer integer2)
            {
                return integer * integer2;
            }
        };
        BiFunction<String,String,String> f3 = (s1,s2) -> s1.concat(s2);

        BiFunction<String,String,String> f4 = String::concat;
    }
}
