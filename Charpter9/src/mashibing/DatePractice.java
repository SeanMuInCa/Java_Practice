package mashibing;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Purpose:             To output sum of two integers. <br />
 * To use run the main method. <br />
 * Data Submitted:      2023/11/9 <br />
 * Assignment Number:   Lab 1  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:          lab1/Program1.java <br />
 *
 * @author George Ding (instructor - no SDC#)
 * @version 1.0.0
 */
public class DatePractice
{
    public static void main(String[] args)
    {
        System.out.print("请输入日期:");
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        Calendar calendar = Calendar.getInstance();
        //String ---> Calendar
        java.sql.Date date = java.sql.Date.valueOf(line);
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        int startDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println(year + "年 - " + month + "月:");
        printCalendarHead();
        int maxDay = calendar.getActualMaximum(Calendar.DATE);
        printCalendarBody(maxDay, day, startDay);
    }

    private static void printCalendarBody(int max, int day, int startDay)
    {
        int length = 1;

        for (int i = 1 - startDay; i <= max; i++, length++)
        {
            if (i < 1)
            {
                System.out.print("\t");
            } else if (i == day) System.out.print(i + "*" + "\t");
            else
            {
                System.out.print(i + "\t");
            }
            if (length % 7 == 0)
                System.out.println();
        }
    }

    private static void printCalendarHead()
    {
        for (int i = 0; i < 7; i++)
        {
            System.out.print(getDateString(i) + '\t');
        }
        System.out.println();
    }

    private static String getDateString(int date)
    {
        switch (date)
        {
            case 0 ->
            {
                return "日";
            }
            case 1 ->
            {
                return "一";
            }
            case 2 ->
            {
                return "二";
            }
            case 3 ->
            {
                return "三";
            }
            case 4 ->
            {
                return "四";
            }
            case 5 ->
            {
                return "五";
            }
            default ->
            {
                return "六";
            }
        }
    }
}
