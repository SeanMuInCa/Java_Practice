package TestEnum3;

/**
 * Purpose:             TestEnum3<br />
 * Data Submitted:      2023/12/2 <br />
 * Assignment Number:    TestEnum3<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestEnum3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Person
{
    private int age;
    private String name;
    private Sex sex;

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Sex getSex()
    {
        return sex;
    }

    public void setSex(Sex sex)
    {
        this.sex = sex;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
