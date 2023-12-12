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
public class HourlyEmployee extends Employee
{
    private double wage;
    private int hours;

    public HourlyEmployee()
    {
    }

    public HourlyEmployee(String name, MyDate birthDate, double wage, int hours)
    {
        super(name,birthDate);
        this.wage = wage;
        this.hours = hours;
    }

    public double getWage()
    {
        return wage;
    }

    public void setWage(double wage)
    {
        this.wage = wage;
    }

    public int getHours()
    {
        return hours;
    }

    public void setHours(int hours)
    {
        this.hours = hours;
    }

    public double earnings()
    {
        return wage * hours;
    }

    @Override
    public String toString()
    {
        return "HourlyEmployee{" + super.toString() + "} ";
    }
}
