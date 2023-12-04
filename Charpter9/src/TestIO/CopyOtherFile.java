package TestIO;

import java.io.*;

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
public class CopyOtherFile
{
    public static void main(String[] args) throws IOException
    {
        //读取文件
        File f = new File("src/raina.jpg");
        //输入流
        FileInputStream fis = new FileInputStream(f);
        //目标图片
        File f1 = new File("src/a.jpg");
        //输出流
        FileOutputStream fos = new FileOutputStream(f1);
        long start = System.currentTimeMillis();
        //构建缓冲数组
        byte[] outData = new byte[1024 * 10];
        int len = fis.read(outData);
        while ((len != -1)){
            //写入新文件
            fos.write(outData, 0, len);
            len = fis.read(outData);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //关闭流
        fos.close();
        fis.close();
    }
}
