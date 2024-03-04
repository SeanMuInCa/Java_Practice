package Class0304_junit;

/**
 * Purpose:             Class0304_junit<br />
 * Data Submitted:      2024/3/4 <br />
 * Assignment Number:    Class0304_junit<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Class0304_junit <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Clock
{
    public static boolean isValidMinute(int minute)
    {
        return minute < 60 && minute >= 0;
    }
    public static boolean isValidHour(int hour)
    {
        return hour < 24 && hour >= 0;
    }
}
