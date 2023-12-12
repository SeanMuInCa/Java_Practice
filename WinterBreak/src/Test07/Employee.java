package Test07;

/**
 * Purpose:             Test07<br />
 * Data Submitted:      2023/12/11 <br />
 * Assignment Number:    Test07<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Test07 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public abstract class Employee
{
    private String name;
    public static int numberCounter = 1000;
    private int number;
    private MyDate birthDate;

    public Employee()
    {
        numberCounter++;
        this.number = numberCounter;
    }

    public Employee(String name, MyDate birthDate)
    {
        this();
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public MyDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public abstract double earnings();

    @Override
    public String toString()
    {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthDate=" + birthDate.toDateString() +
                '}';
    }
}
