package Project.domain;

/**
 * Purpose:             Project.domain<br />
 * Data Submitted:      2023/12/14 <br />
 * Assignment Number:    Project.domain<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Project.domain <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Employee
{
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    protected String getDes(){
        return id + "\t" + name + "\t" + age + "\t" + salary;
    }
    @Override
    public String toString()
    {
        return getDes();
    }
    public String getDetails()
    {
        return "";
    }
}
