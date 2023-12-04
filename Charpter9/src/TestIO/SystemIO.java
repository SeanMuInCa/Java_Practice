package TestIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Purpose:             TestIO<br />
 * Data Submitted:      2023/11/17 <br />
 * Assignment Number:    TestIO<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestIO <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class SystemIO
{
    public static void main(String[] args) throws IOException
    {
        InputStream is = System.in;
        int n = is.read();
        String str = "";
        while (n != 10){
            str += (char)n;
            n = is.read();
        }
        System.out.println(str);
        File f = new File("src/abc.txt");
        FileWriter fw = new FileWriter(f);
        fw.write(str);
        fw.close();
    }
}
