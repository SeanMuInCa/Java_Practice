package TestStream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Purpose:             TestStream<br />
 * Data Submitted:      2024/2/13 <br />
 * Assignment Number:    TestStream<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestStream <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Practice3
{
    @Test
    public void test(){
        List<Person> list = PersonData.getPersonList();

        List<Person> list1 = list.stream()
                .filter(p -> p.getAge() > 15)
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(list1);
    }
}
