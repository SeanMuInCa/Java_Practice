/**
 * Purpose:             To output sum of two integers. <br />
 * To use run the main method. <br />
 * Data Submitted:      2023/11/12 <br />
 * Assignment Number:   Lab 1  <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          PACKAGE_NAME <br />
 *
 * @author Zhenghua Mu (instructor - no SDC#)
 * @version 1.0.0
 */
public class TestStringBuilder
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        char[] fruits = {
            'a','b','c','d'
        };
        System.out.println(sb + " " + sb.length());
        sb.append(fruits);
        System.out.println(sb.capacity());
        System.out.println(sb + " " + sb.length());
        sb.append(fruits,0,3);
        System.out.println(sb + " " + sb.length());
        sb.append(5);
        sb.append(true);
        sb.append("java!");
        System.out.println(sb + " " + sb.length());
        sb.delete(0,2);
        System.out.println(sb + " " + sb.length());
        sb.insert(1, new char[]{'a', 'b','c'},1,2);//start index sb
        System.out.println(sb + " " + sb.length());
        sb.setCharAt(0,'A');
//        sb.reverse();
        System.out.println(sb + " " + sb.length());
        sb.replace(4,6,"@@@@@");
        System.out.println(sb + " " + sb.length());
        System.out.println(sb.capacity());
        System.out.println(Character.isLetterOrDigit('@'));
    }
}
