package TestIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Purpose:             TestIO<br />
 * Data Submitted:      2023/11/16 <br />
 * Assignment Number:    TestIO<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestIO <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class FileOutputTest
{
    public static void main(String[] args) throws IOException
    {
        File f = new File("src/a.jpg");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(new byte[] {1,2,3});
        fos.close();
    }
}
