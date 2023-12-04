package TestIO;

import java.io.*;

/**
 * Purpose:             TestIO<br />
 * Data Submitted:      2023/11/17 <br />
 * Assignment Number:    TestIO<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestIO <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class InputSaveTxt
{
    public static void main(String[] args) throws IOException
    {
        //输入准备
        //键盘输入流，字节流
        InputStream is = System.in;
        //字节流转为字符流
        InputStreamReader isr = new InputStreamReader(is);
        //缓冲加强字符流
        BufferedReader br = new BufferedReader(isr);
        //输出准备
        File f = new File("src/abc.txt");
        //字符输出流
        FileWriter fw = new FileWriter(f);
        //字符加强缓冲流
        BufferedWriter bw = new BufferedWriter(fw);
        //操作
        String line = br.readLine();
        while (!line.equals("-1")) {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        }
        //关闭
        bw.close();
        br.close();
    }
}
