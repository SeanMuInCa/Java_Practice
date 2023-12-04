package TestIO;

import java.io.*;

/**
 * Purpose:             TestIO<br />
 * Data Submitted:      2023/11/19 <br />
 * Assignment Number:    TestIO<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestIO <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestPersonSerializable1
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        //创建读取流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src/serializable.txt")));
        //读取
        Person person = (Person) ois.readObject();
        System.out.println(person);
        //关闭流
        ois.close();
    }
}
