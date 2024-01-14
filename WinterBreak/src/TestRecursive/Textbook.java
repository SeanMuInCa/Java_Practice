package TestRecursive;

import org.junit.Test;

/**
 * Purpose:             TestRecursive<br />
 * Data Submitted:      2024/1/14 <br />
 * Assignment Number:    TestRecursive<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestRecursive <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Textbook
{
    @Test
    public void test1(){
        printMSG(5,"hello");
        System.out.println(isPalindromes("uncle"));
    }
    public void printMSG(int times, String msg){
        if(times == 1) System.out.println(msg);
        else {
            System.out.println(msg);
            printMSG(times - 1, msg);
        }
    }
    public boolean isPalindromes(String str){
        if(str.length() <= 1) return true;
        else if(str.charAt(0) != str.charAt(str.length() - 1)) return false;
        else return isPalindromes(str.substring(1,str.length() - 2));
    }
}
