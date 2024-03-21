package TestFileAndIO1;

import org.junit.Test;

import java.io.*;

/**
 * Purpose:             TestFileAndIO1<br />
 * Data Submitted:      2023/12/23 <br />
 * Assignment Number:    TestFileAndIO1<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestFileAndIO1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 复制图片
 */
public class FileInputOutputStreamTest
{
    @Test
    public void test()
    {
        try (
                //字节流是万能拷贝流
//                FileInputStream fis = new FileInputStream("d:\\Java\\原型链.png");
                FileInputStream fis = new FileInputStream("d:\\Java\\res.txt");
//                FileOutputStream fos = new FileOutputStream("d:\\Java\\原型链_copy.png");
                FileOutputStream fos = new FileOutputStream("d:\\Java\\res_copy.txt");
        )
        {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1)
            {
                fos.write(buffer, 0, length);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
