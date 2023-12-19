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
public class Interview3
{
    private static void change(String s, StringBuffer sb){
        s = "aaaa";
        sb.setLength(0);
        sb.append("aaaa");
    }

    public static void main(String[] args)
    {
        String s = "bbbb";
        StringBuffer sb = new StringBuffer("bbbb");
        change(s, sb);
        System.out.println(s + sb);
    }
}
