package TestFileAndIO1;

import org.junit.Test;

import java.io.*;

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
 * InputStreamReader: from byte to char
 * OutputStreamWriter: from char to byte
 */
public class ProcessStreamTest
{
    @Test
    public void test() throws IOException
    {
        File file = new File("d:\\Java\\test_utf8.txt");
        FileInputStream fis = new FileInputStream(file);//字节流
        InputStreamReader isr = new InputStreamReader(fis);//字符流utf8默认的字符集
        //读入操作
        char[] buffer = new char[1024];
        int length;
        while ((length = isr.read(buffer))!= -1)
        {
            System.out.println(new String(buffer, 0, length));
        }
        if (isr!= null)
        {
            isr.close();
        }
    }

    @Test
    public void test1() throws IOException
    {
        File file = new File("d:\\Java\\test_gbk.txt");
        FileInputStream fis = new FileInputStream(file);//字节流
        InputStreamReader isr = new InputStreamReader(fis,"gbk");//字符流指定gbk字符集
        //读入操作
        char[] buffer = new char[1024];
        int length;
        while ((length = isr.read(buffer))!= -1)
        {
            System.out.println(new String(buffer, 0, length));
        }
        if (isr!= null)
        {
            isr.close();
        }
    }

    /*
    * 需求：将gbk文件转换为utf-8文件
    * */
    @Test
    public void test2() throws IOException
    {
        File file = new File("d:\\Java\\test_gbk.txt");
        File file1 = new File("d:\\Java\\test_utf8_copy.txt");
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"gbk");
        OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(file1), "utf-8");
        char[] buffer = new char[1024];
        int length;
        while ((length = isr.read(buffer)) != -1){
            osr.write(buffer,0,length);
        }
        osr.close();
        isr.close();
    }
}
