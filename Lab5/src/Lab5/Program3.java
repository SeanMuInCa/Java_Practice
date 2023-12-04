package Lab5;

/**
 * Purpose:             To display the middle character of a string <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   lab5  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           lab5/Program3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Program3
{
    /**
     * To display the middle character of a string
     *
     * @param inStr String the input string words
     * @return String the middle part of the string
     */
    public static String middle(String inStr)
    {
        int position, length;
        if (inStr.length() % 2 == 0)
        {
            position = inStr.length() / 2 - 1;
            length = 2;
        } else
        {
            position = inStr.length() / 2;
            length = 1;
        }
        return inStr.substring(position, position + length);
    }
}
