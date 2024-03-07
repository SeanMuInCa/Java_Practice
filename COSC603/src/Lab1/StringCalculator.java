package Lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose:             Lab1<br />
 * Data Submitted:      2024/3/6 <br />
 * Assignment Number:    Lab1<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          Lab1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class StringCalculator
{
    public static int add(String numbers)
    {
        String delimiter = ",|\n";
        String numbersWithoutDelimiters = numbers;

        if (numbers.startsWith("//"))
        {
            int delimiterIndex = numbers.indexOf("//") + 2;
            delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
            numbersWithoutDelimiters = numbers.substring(numbers.indexOf("\n") + 1);
        }

        return add(numbersWithoutDelimiters, delimiter);
    }

    /**
     * Takes a string of numbers with a delimiter between them and adds them up
     * @param numbers   a string of numbers separated by a delimiter
     * @param delimiter a string with a separator
     * @return sum of the numbers in the string
     */
    private static int add(final String numbers, final String delimiter)
    {
        int sum = 0;
        String[] numbersArray = numbers.split(delimiter);
        List negatives = new ArrayList();

        for (String number : numbersArray)
        {
            if (!number.trim().isEmpty())
            {
                int numberInt = Integer.parseInt(number);
                if (numberInt < 0)
                {
                    negatives.add(numberInt);
                }
                if (numberInt <= 1000)
                {
                    sum += numberInt;
                }
            }
        }
        if (!negatives.isEmpty())
        {
            throw new RuntimeException("Negatives are not allowed: " +
                    negatives.toString());
        }

        return sum;
    }
}
