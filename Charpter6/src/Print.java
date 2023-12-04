import java.lang.reflect.Array;
import java.util.Scanner;

public class Print
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        // Prompt the user to enter year
        System.out.print("Enter full year (e.g., 2012): ");
        int year = input.nextInt();
        // Prompt the user to enter month
        System.out.print("Enter month as a number between 1 and 12: ");
        int month = input.nextInt();
        // Print calendar for the month of the year
        printMonth(year, month);
    }

    /**
     * A stub for printMonth may look like this
     */
    public static void printMonth(int year, int month)
    {
//        System.out.print(month + " " + year);
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    /**
     * A stub for printMonthTitle may look like this
     */
    public static void printMonthTitle(int year, int month)
    {
        String sMonth = getMonthName(month);
        System.out.println(sMonth + " " + year);
        System.out.println("----------------------------------");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

    }

    /**
     * A stub for printMonthBody may look like this
     */
    public static void printMonthBody(int year, int month)
    {
        int start = getStartDay(year, month);
        int date = 1;
        int days = getNumberOfDaysInMonth(year, month);
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 7 && date <= days; j++)
            {
                if (j < start)
                    System.out.print("\t");
                else
                {
                    if (date < 10)
                    {
                        System.out.print("  " + date + " ");
                    } else
                        System.out.print("  " + date);
                    date++;
                }
            }
            start = 0;
            System.out.println();
        }
    }

    /**
     * A stub for getMonthName may look like this
     */
    public static String getMonthName(int month)
    {
        switch (month)
        {
            case 1 ->
            {
                return "January";
            }
            case 2 ->
            {
                return "February";
            }
            case 3 ->
            {
                return "March";
            }
            case 4 ->
            {
                return "April";
            }
            case 5 ->
            {
                return "May";
            }
            case 6 ->
            {
                return "June";
            }
            case 7 ->
            {
                return "July";
            }
            case 8 ->
            {
                return "August";
            }
            case 9 ->
            {
                return "September";
            }
            case 10 ->
            {
                return "October";
            }
            case 11 ->
            {
                return "November";
            }
            case 12 ->
            {
                return "December";
            }
        }
        return "";
    }

    /**
     * A stub for getStartDay may look like this
     */
    public static int getStartDay(int year, int month)
    {
        int total = getTotalNumberOfDays(year, month);

        return (total + 3) % 7; // A dummy value
    }

    /**
     * A stub for getTotalNumberOfDays may look like this
     */
    public static int getTotalNumberOfDays(int year, int month)
    {
        int total = 0;
        for (int i = 1800; i < year; i++)
        {
            total += isLeapYear(i) ? 366 : 365;
        }

        for (int i = 1; i < month; i++)
        {
            total += getNumberOfDaysInMonth(year, i);
        }
        return total; // A dummy value
    }

    /**
     * A stub for getNumberOfDaysInMonth may look like this
     */
    public static int getNumberOfDaysInMonth(int year, int month)
    {
        int days = 0;
        switch (month)
        {
            case 1, 5, 3, 7, 8, 10, 12 -> days = 31;

            case 2 ->
            {
                days = isLeapYear(year) ? 29 : 28;
            }
            case 4, 6, 9, 11 -> days = 30;
        }
        return days; // A dummy value
    }

    /**
     * A stub for isLeapYear may look like this
     */
    public static boolean isLeapYear(int year)
    {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}

