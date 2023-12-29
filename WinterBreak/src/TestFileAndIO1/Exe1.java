package TestFileAndIO1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
 * 写一个模仿scanner的类
 */
public class Exe1
{
    @Test
    public void test()
    {
        System.out.println("input");
        MyInput input = new MyInput(System.in);
//        System.out.println(input.readString());
        System.out.println(input.readInt());
    }
}

class MyInput
{
    BufferedReader br1 = null;
    String str = null;

    public MyInput(InputStream br)
    {
        this.br1 = new BufferedReader(new InputStreamReader(br));
    }

    public String readString()
    {
        BufferedReader br = this.br1;
        try
        {
            str = br.readLine();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            try
            {
                if (br != null)
                    br.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return str;
    }
    public int readInt()
    {
        return Integer.parseInt(readString());
    }
    public double readDouble()
    {
        return Double.parseDouble(readString());
    }
    public double readFloat()
    {
        return Float.parseFloat(readString());
    }
    public char readChar()
    {
        return readString().charAt(0);
    }
}