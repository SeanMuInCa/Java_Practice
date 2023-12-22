package TestGenerics;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Purpose:             TestGenerics<br />
 * Data Submitted:      2023/12/22 <br />
 * Assignment Number:    TestGenerics<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestGenerics <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class GenericTest
{
    @Test
    public void test(){
        Person<Integer> p1 = new Person<>(9,"Zhenghua Mu", 20);
        Person<String> p2 = new Person<>("abc","Zhenghua Mu", 20);
        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        for (Person p : list) {
            System.out.println(p);
        }
    }
    @Test
    public void test2(){
        Worker w1 = new Worker();
        Student s1 = new Student();
    }
}
