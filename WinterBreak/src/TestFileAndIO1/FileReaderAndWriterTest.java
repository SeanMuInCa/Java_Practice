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
        while (data != -1){
            System.out.println((char)data);
            data = fr.read();
        }
//        fw.close();
        fr.close();
    }
    @Test
    public void test1()
    {
        File file1 = new File("d:\\Java\\test.txt");
        FileReader fr = null;
        try
        {
            fr = new FileReader(file1);
            //方式1
        /*while (fr.ready()){
            System.out.println((char)fr.read());
        }*/
            //方式2
            int data = fr.read();
            while (data != -1){
                System.out.println((char)data);
                data = fr.read();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(fr != null)
                    fr.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
