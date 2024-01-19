package TestFileAndIO1;

import org.junit.Test;

import java.io.*;

/**
 * Purpose:             TestFileAndIO1<br />
 * Data Submitted:      2024/1/18 <br />
 * Assignment Number:    TestFileAndIO1<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestFileAndIO1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TextBook
{
    @Test
    public void test1()
    {
        String str1 = null, str2 = null;
        File sourceFile = new File("d:\\test\\a.txt");
        try
        {
            FileReader fr = new FileReader(sourceFile);
            char[] buffer = new char[1024];

            int length;
            while ((length = fr.read(buffer)) != -1)
            {//这里返回的是读取的长度
                str1 += new String(buffer);
            }
            fr.close();
            System.out.println(str1);
            String s = str1.replaceAll("abc", "raina");
            System.out.println(s);
            FileWriter fw = new FileWriter(sourceFile);
            fw.write(s);
            fw.close();
           /*input.close();
           PrintWriter output = new PrintWriter(sourceFile);
           output.println(str2);*/
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2()
    {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try
        {
            fis = new FileInputStream("d:\\test\\a.txt");
            int b = fis.read();
            while (b != -1)
            {
                b = fis.read();
            }
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            if (fis != null)
            {
                try
                {
                    fis.close();
                } catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
            if (fos != null)
            {
                try
                {
                    fos.close();
                } catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
