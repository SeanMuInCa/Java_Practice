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
public class ObjectStream
{
    public static void main(String[] args) throws IOException
    {
        //将内存中的字符串写道文件中  序列化
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("src/string.txt")));
        //字符串写到文件中
        os.writeObject("你好");
        os.close();
    }
}
