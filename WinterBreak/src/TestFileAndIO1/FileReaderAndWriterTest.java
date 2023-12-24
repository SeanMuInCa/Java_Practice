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
 * 读取文件中的内容并显示
 */
public class FileReaderAndWriterTest
{
    @Test
    public void test() throws IOException
    {
        File file1 = new File("d:\\Java\\test.txt");
        FileReader fr = new FileReader(file1);
//        FileWriter fw = new FileWriter(file1);
        //方式1
        /*while (fr.ready()){
            System.out.println((char)fr.read());
        }*/
        //方式2
        int data = fr.read();
        while (data != -1)
        {
            System.out.println((char) data);
            data = fr.read();
        }
//        fw.close();
        fr.close();
    }

    @Test
    public void test1()
    {
        FileReader fr = null;
        try
        {
            File file1 = new File("d:\\Java\\test.txt");
            fr = new FileReader(file1);
            //方式1
        /*while (fr.ready()){
            System.out.println((char)fr.read());
        }*/
            //方式2
            int data = fr.read();
            while (data != -1)
            {
                System.out.println((char) data);
                data = fr.read();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (fr != null)
                    fr.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2()
    {
        //final version
        FileReader fr = null;
        try
        {
            File file1 = new File("d:\\Java\\test.txt");
            fr = new FileReader(file1);
            char[] buffer = new char[1024];
            int length = fr.read(buffer);//这里返回的是读取的长度
            while (length != -1)
            {
                for (int i = 0; i < length; i++)
                {
                    System.out.print(buffer[i]);
                }
                length = fr.read(buffer);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (fr != null)
                    fr.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /*
     * 写内容到一个文本里
     * */
    @Test
    public void test3()
    {


        FileWriter fw = null;
        try
        {
            File file2 = new File("d:\\Java\\res.txt");
            fw = new FileWriter(file2);
            fw.write("java");

        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (fw != null)
                {
                    fw.close();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4()
    {
        //final version of text
        FileReader fr = null;
        FileWriter fw = null;
        try
        {
            File file1 = new File("d:\\Java\\test.txt");
            fr = new FileReader(file1);

            File file2 = new File("d:\\Java\\res.txt");
            fw = new FileWriter(file2);

            char[] buffer = new char[1024];

            int length;
            while ((length = fr.read(buffer)) != -1)
            {//这里返回的是读取的长度
                fw.write(buffer, 0, length);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (fr != null)
                    fr.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if (fw != null)
                    fw.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
