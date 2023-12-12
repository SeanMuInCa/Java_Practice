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
public class PayrollSystem
{
    public static void main(String[] args)
    {
        Employee[] employees = new Employee[3];
        employees[0] = new HourlyEmployee("George", new MyDate(1999, 1, 12), 550, 40);
        employees[1] = new SalariedEmployee("John", new MyDate(1999, 2, 12), 20000);
        employees[2] = new HourlyEmployee("Jane", new MyDate(1999, 3, 12), 700, 40);
        for (int i = 0; i < employees.length; i++)
        {
            System.out.println("Employee " + (i + 1) +" "+ employees[i] + " earnings: " + employees[i].earnings());
        }
    }
}
