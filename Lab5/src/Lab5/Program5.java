package Lab5;

/**
 * Purpose:             To count all words in a string <br />
 * Data Submitted:      10/05/2023 <br />
 * Assignment Number:   lab5  <br />
 * Course Name:         COSC600  <br />
 * Instructor:          George Ding  <br />
 * File Path:           lab5/Program5 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Program5
{
    public static void main(String[] args)
    {
        System.out.println(countWords(""));
    }

    /**
     * To count all words in a string
     *
     * @param inString String the input string words
     * @return int the amount of words in the string param
     */
    public static int countWords(String inString)
    {
        int count = 0;
        inString = inString.trim();
        //test the user's input
        if (inString.length() > 0)
        {
            for (int i = 0; i < inString.length(); i++)
            {
                if (inString.charAt(i) == ' ')
                {
                    count++;
                }
            }
            return count + 1;
        } else return count;
    }
}
