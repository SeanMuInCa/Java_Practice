package TestLambda;

import java.util.Comparator;
import java.util.function.*;

/**
 * Purpose:             TestLambda<br />
 * Data Submitted:      2024/2/29 <br />
 * Assignment Number:    TestLambda<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestLambda <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TextBook2
{
    Consumer c = new Consumer()
    {
        @Override
        public void accept(Object o)
        {
            System.out.println(o);
        }
    };
    Consumer c1 = o -> System.out.println(o);
    Function<String, Integer> f = new Function<String, Integer>()
    {
        @Override
        public Integer apply(String s)
        {
            return null;
        }
    };
    Function<String, Integer> f1 = s -> Integer.parseInt(s);
    Predicate<Integer> p = new Predicate<Integer>()
    {
        @Override
        public boolean test(Integer integer)
        {
            return false;
        }
    };
    Predicate<Integer> p1 = s -> s == 0;

    Comparator<String> com1 = new Comparator<String>()
    {
        @Override
        public int compare(String o1, String o2)
        {
            return 0;
        }
    };
    Comparator<String> com2 = (s1,s2) -> s1.compareTo(s2);

    BiFunction<String,String,Integer> bi1 = new BiFunction<String, String, Integer>()
    {
        @Override
        public Integer apply(String s, String s2)
        {
            return null;
        }
    };
    BiFunction<String,String,Integer> bi2 = (s1,s2) -> s1.compareTo(s2);

    Supplier<String> s1 = new Supplier<String>()
    {
        @Override
        public String get()
        {
            return null;
        }
    };
    Supplier<String> s2 = () -> "";
}
