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
public class SalariedEmployee extends Employee
{
    private double monthlySalary;

    public SalariedEmployee()
    {
    }

    public SalariedEmployee(String name, MyDate birthDate, double monthlySalary)
    {
        super(name,  birthDate);
        this.monthlySalary = monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary)
    {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings()
    {
        return monthlySalary;
    }

    @Override
    public String toString()
    {
        return "SalariedEmployee{" + super.toString() + "} ";
    }
}
