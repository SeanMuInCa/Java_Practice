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
public class Interview4
{
    public static void main(String[] args)
    {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());

        System.out.println(sb);

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
