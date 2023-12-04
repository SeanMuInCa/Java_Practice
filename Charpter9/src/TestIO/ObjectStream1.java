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
public class ObjectStream1
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        //读取Object 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src/string.txt")));
        Object object = ois.readObject();
        System.out.println(object);
        ois.close();
    }
}
