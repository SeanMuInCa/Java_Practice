package TestLambda;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Purpose:             TestLambda<br />
 * Data Submitted:      2024/1/10 <br />
 * Assignment Number:    TestLambda<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestLambda <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestFunc
{
    @Test
    public void test1(){
        Map<Integer,Employee> map = new HashMap<>();
        Employee e1 = new Employee(1,"raina1",10000);
        Employee e2 = new Employee(2,"raina2",20000);
        Employee e3 = new Employee(3,"raina3",30000);
        Employee e4 = new Employee(4,"raina4",40000);

        map.put(e1.getId(),e1);
        map.put(e2.getId(),e2);
        map.put(e3.getId(),e3);
        map.put(e4.getId(),e4);

        map.forEach((id,e) -> System.out.println(e.getName()));
    }
}
