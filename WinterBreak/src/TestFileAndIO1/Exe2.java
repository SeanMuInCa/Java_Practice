package TestFileAndIO1;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

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
 * print流
 */
public class Exe2
{
    @Test
    public void test() throws FileNotFoundException
    {
        PrintStream ps = new PrintStream("d:\\Java\\abc.txt");
        for (int i = 0; i < 100; i++) {
            ps.println(i);
        }
        System.setOut(ps);//设置默认输出流
        System.out.println("raina how are you!");
        ps.close();
    }
}
