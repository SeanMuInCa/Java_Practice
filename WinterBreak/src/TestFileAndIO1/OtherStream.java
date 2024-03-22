package TestFileAndIO1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Purpose:             TestFileAndIO1<br />
 * Data Submitted:      2023/12/24 <br />
 * Assignment Number:    TestFileAndIO1<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestFileAndIO1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 输入一段文字，输出大写形式
 */
public class OtherStream
{
    @Test
    public void test(){
        System.out.println("input a string(e for exit): ");

        String str;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            while ((str = br.readLine())!= null)
            {
                if (str.equals("e"))
                {
                    break;
                }
                System.out.println("--> " + str.toUpperCase());
                System.out.println("input a string ");
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
