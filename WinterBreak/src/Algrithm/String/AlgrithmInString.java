package Algrithm.String;

/**
 * Purpose:             Algrithm.String<br />
 * Data Submitted:      2024/2/5 <br />
 * Assignment Number:    Algrithm.String<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Algrithm.String <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class AlgrithmInString
{
    private static String recReverse(String str)
    {
        if(str.isEmpty()) return "";
        return recReverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args)
    {
        String str = "ab";
        System.out.println(recReverse(str));
    }
}
