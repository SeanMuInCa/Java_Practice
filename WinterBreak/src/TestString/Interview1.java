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
 * 这个需要画一下内存图，才好看明白
 */
public class Interview1
{
    public static void main(String[] args)
    {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operater(a, b);
        System.out.println(a + " - " + b);
    }
    public static void operater(StringBuffer x, StringBuffer y){
        x.append(y);
        y = x;
        y.append("x");
    }
}
