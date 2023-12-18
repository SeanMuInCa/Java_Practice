package TestString;

/**
 * Purpose:             TestString<br />
 * Data Submitted:      2023/12/18 <br />
 * Assignment Number:    TestString<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestString <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Exe1
{
    public static void main(String[] args)
    {
        String str = "  Hello World  ";
        System.out.println(myTrim(str));
    }
    public static String myTrim(String str){
        int start = 0;
        int end = str.length() - 1;
        for (int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) != ' '){
                start = i;
                break;
            }
        }
        for (int i = str.length() - 1; i >= 0 ; i--)
        {
            if(str.charAt(i) != ' '){
                end = i;
                break;
            }
        }
        return str.substring(start, end + 1);
    }
}
