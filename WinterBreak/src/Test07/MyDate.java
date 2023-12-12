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
public class MyDate
{
    private int year;
    private int month;
    private int day;

    public MyDate()
    {
    }

    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toDateString()
    {
        return  year + "year" + month + "month" + day + "day";
    }
}
