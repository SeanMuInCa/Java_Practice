package TestLambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
}
