package TestLambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;

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
        Comparator<String> com3 = String::compareTo;
    }
    @Test
    public void test2(){
        BiPredicate<String,String> bi1 = new BiPredicate<String, String>()
        {
            @Override
            public boolean test(String s1, String s2)
            {
                return s1.equals(s2);
            }
        };
        BiPredicate<String, String> bi2 = (s1, s2) -> s1.equals(s2);
        BiPredicate<String, String> bi3 = String::equals;
    }
    @Test
    public void test3(){
        Person p = new Person("raina",14);
        Function<Person, String> fun1 = new Function<Person, String>()
        {
            @Override
            public String apply(Person person)
            {
                return person.getName();
            }
        };
        Function<Person, String> fun2 = p1 -> p1.getName();
        Function<Person, String> fun3 = Person::getName;
    }
}
