package Class0304_junit;

import static org.junit.jupiter.api.Assertions.*;

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
class ClockTest
{

    @org.junit.jupiter.api.Test
    void isValidMinute()
    {
        assertTrue(Clock.isValidMinute(59));
        assertTrue(Clock.isValidMinute(0));
        assertFalse(Clock.isValidMinute(-1));
        assertFalse(Clock.isValidMinute(60));
    }

    @org.junit.jupiter.api.Test
    void isValidHour()
    {
        assertTrue(Clock.isValidHour(0));
        assertTrue(Clock.isValidHour(23));
        assertFalse(Clock.isValidHour(-1));
        assertFalse(Clock.isValidHour(24));
    }
}