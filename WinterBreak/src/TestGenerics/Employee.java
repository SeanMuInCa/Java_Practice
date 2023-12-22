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
public class Employee implements Comparable<Employee>
{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday)
    {
        setAge(age);
        setName(name);
        setBirthday(birthday);
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

    public MyDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(MyDate birthday)
    {
        this.birthday = birthday;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Employee o)
    {
        return this.name.compareTo(o.name);
    }
}
