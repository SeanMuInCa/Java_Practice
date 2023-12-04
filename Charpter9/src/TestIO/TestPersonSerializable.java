package TestIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
public class TestPersonSerializable
{
    public static void main(String[] args) throws IOException
    {
        //序列化：将内存中的对象写到磁盘中
        //1.创建对象
        Person p = new Person("zs", 19);
        //2.创建流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src/serializable.txt")));
        //3写入磁盘
        oos.writeObject(p);
        //4.关闭流
        oos.close();
    }
}
