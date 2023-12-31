package TestReflect02;

import java.io.Serializable;

/**
 * Purpose:             TestReflect02<br />
 * Data Submitted:      2023/12/3 <br />
 * Assignment Number:    TestReflect02<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestReflect02 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Person implements Serializable
{
    private int age;
    public String name;
    private void eat(){
        System.out.println("Person ---- eat");
    }
    public void sleep(){
        System.out.println("Person --- sleep");
    }
}
