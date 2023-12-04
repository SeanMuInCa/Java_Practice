package TestIO;

import java.io.Serial;
import java.io.Serializable;

/**
 * Purpose:             TestIO<br />
 * Data Submitted:      2023/11/19 <br />
 * Assignment Number:    TestIO<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestIO <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Person implements Serializable
{
    @Serial
    private static final long serialVersionUID = 3491746999812760546L;
    //    private final static long serialVersionUID = 1L;
    private String name;
    private int age;
    private double height;
    private double weight;
    int a;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Person()
    {
    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
