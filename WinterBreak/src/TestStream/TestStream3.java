package TestStream;

import org.junit.Test;

import java.util.List;

/**
 * Purpose:             TestStream<br />
 * Data Submitted:      2024/1/5 <br />
 * Assignment Number:    TestStream<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestStream <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 终止操作
 */
public class TestStream3
{
    //匹配与查找
    @Test
    public void test1(){
        List<Person> list = PersonData.getPersonList();
        System.out.println(list.stream().allMatch(person -> person.getName().startsWith("raina")));
    }
}
