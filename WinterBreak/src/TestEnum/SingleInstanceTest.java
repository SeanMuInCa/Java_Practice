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
public class SingleInstanceTest
{
    public static void main(String[] args)
    {
        Wife fiona = Wife.Fiona;
        System.out.println(fiona);

    }
}
enum Wife{
    Fiona;
}
