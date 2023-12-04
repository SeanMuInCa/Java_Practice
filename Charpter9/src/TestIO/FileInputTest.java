package TestIO;

import java.io.File;
import java.io.FileInputStream;
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
public class FileInputTest
{
    public static void main(String[] args) throws IOException
    {
        //确定源文件
        File f = new File("src/raina.jpg");
        //创建字节流，字节流读取非文本文件
        FileInputStream fis = new FileInputStream(f);
        //读取
        /*
        * 文件是utf-8存储的，所以英文占1字节，中文占3字节。
        * 如果读文本就会拆中文字节，所以不能用这个读文本。
        * */
        //1.一个字节一个字节读取
        /*int count = 0;
        int n;
        while ((n = fis.read()) != -1){
            System.out.println((char)n);
            count++;
        }
        System.out.println(count);*/
        /*2.缓冲数组
        * */
        byte[] outData = new byte[1024 * 10];
        int len = fis.read(outData);
        while ((len != -1)){
            for (int i = 0; i < len; i++)
            {
                System.out.println(outData[i]);
            }
            len = fis.read(outData);
        }
        //关闭
        fis.close();
//        System.out.println(count);
    }
}
