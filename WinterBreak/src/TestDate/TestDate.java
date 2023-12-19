package TestDate;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Purpose:             PACKAGE_NAME<br />
 * Data Submitted:      2023/12/18 <br />
 * Assignment Number:    PACKAGE_NAME<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          PACKAGE_NAME <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestDate
{
    @Test
    public void test()
    {
        Date d = new Date();
        System.out.println(d);//Mon Dec 18 21:23:25 CST 2023
        System.out.println(d.getTime());//a million seconds

        Date d1 = new Date(1602054827521l);
        System.out.println(d1);
    }

    @Test
    public void test2()
    {
        java.sql.Date d = new java.sql.Date(1602054827521l);
        System.out.println(d);//2020-10-07
    }

    @Test
    public void test3()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date d = new Date();
        String format = sdf.format(d);
        System.out.println(format);

        try
        {
            Date parse = sdf.parse("12:30:23");
            System.out.println(parse);
        } catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    //Calendar
    @Test
    public void test5()
    {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.MONTH));
    }

    //java.util.Date的实例转化为java.sql.Date的实例
    @Test
    public void test6()
    {
        Date date = new Date();
        java.sql.Date d = new java.sql.Date(date.getTime());
        System.out.println(d);
    }

    @Test
    public void test7() throws ParseException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("input the date");
        String str = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(str);
        java.sql.Date d = new java.sql.Date(parse.getTime());
        System.out.println(d);
    }
}
