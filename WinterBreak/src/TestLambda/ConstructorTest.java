package TestLambda;

import org.junit.Test;

import java.util.function.Function;
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
        Supplier<Person> supplier1 = Person::new;//这里的::是构造器引用，调用空构造器

        Function<Integer,Person> fun1 = new Function<Integer,Person>()
        {
            @Override
            public Person apply(Integer id)
            {
                return new Person(id);
            }
        };
        Function<Integer,Person> fun2 = id -> new Person(id);
        Function<Integer,Person> fun3 = Person::new;//这里的::是构造器引用，调用int id构造器
        System.out.println(fun3.apply(13));
    }
}
