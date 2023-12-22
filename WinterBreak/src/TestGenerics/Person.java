package TestGenerics;

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
public class Person<T>
{
    private T t;
    private String name;
    private int age;

    public Person()
    {
    }

    public Person(T t, String name, int age)
    {
        this.t = t;
        this.name = name;
        this.age = age;
    }

    public T getT()
    {
        return t;
    }

    public void setT(T t)
    {
        this.t = t;
    }

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

    @Override
    public String toString()
    {
        return "Person{" +
                "t=" + t +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
