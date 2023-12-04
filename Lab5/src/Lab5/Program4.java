package Lab5;

/**
 * Purpose:             To count all vowels in a string <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   lab5  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           lab5/Program4 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Program4
{
    /**
     * To count all vowels in a string
     *
     * @param inString String the input string words
     * @return int the amount of vowels in the string param
     */
    public static int countVowels(String inString)
    {
        int count = 0;
        for (int i = 0; i < inString.length(); i++)
        {
            switch (inString.toLowerCase().charAt(i))
            {
                case 'a', 'e', 'i', 'o', 'u' -> count++;
            }
        }
        return count;
    }
}
