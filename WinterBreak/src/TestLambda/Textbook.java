package TestLambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

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
        
    }
}
