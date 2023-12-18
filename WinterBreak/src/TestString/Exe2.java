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
public class Exe2
{
    public static void main(String[] args)
    {
        String str = "abcdefg";
        System.out.println(myReverse(str, 2, 5));
    }
    public static String myReverse(String str, int start, int end){
        String startStr = str.substring(0,start);
        String endStr = str.substring(end + 1);
        String modifyStr = str.substring(start, end + 1);
        String s = "";
        for (int i = modifyStr.length() - 1; i >= 0; i--)
        {
            s += modifyStr.charAt(i);
        }
        return startStr + s + endStr;
    }
}
