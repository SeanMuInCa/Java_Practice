package FunctionalInterface;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Purpose:             FunctionalInterface<br />
 * Data Submitted:      2024/2/12 <br />
 * Assignment Number:    FunctionalInterface<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          FunctionalInterface <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class ConsumerTest
{
    @Test
    public void test(){
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
}
