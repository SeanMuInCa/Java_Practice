package TestDate;

import org.junit.Test;

import java.time.*;

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
 */
public class TestNewDate
{
    @Test
    public void test(){
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        LocalDate date1 = LocalDate.of(2023, 12, 18);
        System.out.println(date1);
    }
    @Test
    public void test1(){
        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println(instant.atOffset(ZoneOffset.ofHours(-6)));
    }
}
