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
public class CopyTextFileBuffed
{
    public static void main(String[] args) throws IOException
    {
        //读取文件
        File f1 = new File("src/Before Sunset2.txt");
        //输入流
        FileReader fr = new FileReader(f1);
        //目标图片
        File f2 = new File("src/Before Sunset2Copy.txt");
        //输出流
        FileWriter fw = new FileWriter(f2);
        //加强读取流,利用buffer
        BufferedReader br = new BufferedReader(fr);
        //加强输出流,利用buffer
        BufferedWriter bw = new BufferedWriter(fw);

        long start = System.currentTimeMillis();
        //开始复制
//        byte[] b = new byte[1024 * 10];
        char[] ch = new char[256];
        int len = br.read(ch);
        while (len != -1)
        {
            bw.write(ch, 0, len);
            len = br.read(ch);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //关闭流
        bw.close();
        br.close();
    }
}
