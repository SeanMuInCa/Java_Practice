package assign2SDC000506980;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Purpose:             To convert a Star Date to the corresponding Calendar<br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   Assignment2  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           assign2SDC000506980/Q4 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Q4
{
    public static void main(String[] args)
    {
        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a star date
        System.out.print("Input a Star Date: ");
        double starTime = input.nextDouble();
        //convert to year and days in int
        int year = (int) starTime;
        int days = (int) ((starTime % 1) * Math.pow(10, countDecimal(starTime)));

        //Create a Calendar object for calculate the date
        Calendar calendar = Calendar.getInstance();
        //set the year to user's input year
        calendar.set(Calendar.YEAR, year);
        //init the month and date to jan.1st
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        //add how many days pass to jan.1
        calendar.add(Calendar.DATE, days);
        // minus 1 day because it's starts from 1 not 0
        System.out.println("The Star Date " + starTime + "'s corresponding Calendar is " + getStringMonth(calendar.get(Calendar.MONTH)) + " " + (calendar.get(Calendar.DATE) - 1) + "," + calendar.get(Calendar.YEAR));
    }

    /**
     * calculate how many numbers after '.'
     * @param number double the star date
     * @return int the number of decimal part
     */
    public static int countDecimal(double number)
    {
        String numberString = number + "";
        int postion = numberString.trim().indexOf('.');
        return numberString.length() - postion - 1;
    }

    /**
     * return month in english
     * @param month int month in number
     * @return String month in english
     */
    public static String getStringMonth(int month)
    {
        String strMonth = "";
        switch (month + 1)
        {
            case 1 -> strMonth = "January";
            case 2 -> strMonth = "February";
            case 3 -> strMonth = "March";
            case 4 -> strMonth = "April";
            case 5 -> strMonth = "May";
            case 6 -> strMonth = "June";
            case 7 -> strMonth = "July";
            case 8 -> strMonth = "August";
            case 9 -> strMonth = "September";
            case 10 -> strMonth = "October";
            case 11 -> strMonth = "November";
            case 12 -> strMonth = "December";
        }
        return strMonth;
    }
}
