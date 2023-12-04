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
public class CopyFileBuffered
{
    public static void main(String[] args) throws IOException
    {
        //读取文件
        File f = new File("src/raina.jpg");
        //输入流
        FileInputStream fis = new FileInputStream(f);
        //目标图片
        File f1 = new File("src/b.jpg");
        //输出流
        FileOutputStream fos = new FileOutputStream(f1);
        //加强读取流,利用buffer
        BufferedInputStream bis = new BufferedInputStream(fis);
        //加强输出流,利用buffer
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        long start = System.currentTimeMillis();
        //开始复制
        byte[] b = new byte[1024 * 10];
        int len = bis.read(b);
        while (len != -1)
        {
            bos.write(b, 0, len);
            len = bis.read(b);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //关闭流
        bos.close();
        bis.close();
    }
}
