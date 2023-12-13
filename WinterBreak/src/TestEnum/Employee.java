package TestEnum;

/**
 * Purpose:             TestEnum<br />
 * Data Submitted:      2023/12/12 <br />
 * Assignment Number:    TestEnum<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestEnum <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Employee
{
    private String name;
    private int age;
    private Status status;

    public Employee()
    {
    }

    public Employee(String name, int age, Status status)
    {
        this.name = name;
        this.age = age;
        this.status = status;
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

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}
