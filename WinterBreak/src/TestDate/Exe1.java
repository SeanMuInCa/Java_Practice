package TestDate;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Purpose:             TestDate<br />
 * Data Submitted:      2023/12/18 <br />
 * Assignment Number:    TestDate<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestDate <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 百天后的日期
 */
public class Exe1
{
    @Test
    public void test(){
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        System.out.println("set your birthday to " + date);

        calendar.add(Calendar.DAY_OF_YEAR, 100);
        System.out.println("100 days later is " + calendar.getTime());
    }

    @Test
    public void test1(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("set your birthday to " + now);
        LocalDateTime localDateTime = now.plusDays(100);
        System.out.println("100 days later is " + localDateTime);
    }
}
