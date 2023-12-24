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
 */
public class BufferedStreamTest
{
    @Test
    public void test(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try
        {
            File src = new File("d:\\Java\\原型链.png");
            File des = new File("d:\\Java\\原型链_copy1.png");
            fis = new FileInputStream(src);
            fos = new FileOutputStream(des);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int length;
            while((length = bis.read(buffer)) != -1){
                bos.write(buffer, 0, length);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (bis != null)
                    bis.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if (bos != null)
                    bos.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }
}
