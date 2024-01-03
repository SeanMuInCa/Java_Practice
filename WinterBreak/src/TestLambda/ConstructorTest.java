package TestLambda;

import org.junit.Test;

import java.util.function.Supplier;

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
 * 构造器引用
 */
public class ConstructorTest
{
    @Test
    public void test(){
        Supplier<Person> supplier = new Supplier<Person>()
        {
            @Override
            public Person get()
            {
                return new Person("raina",14);
            }
        };

        Supplier<Person> supplier1 = () -> new Person();
        Supplier<Person> supplier2 = Person::new;
    }
}
