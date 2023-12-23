package TestFileAndIO;

import java.io.File;
import java.io.IOException;

/**
 * Purpose:             TestFileAndIO<br />
 * Data Submitted:      2023/12/23 <br />
 * Assignment Number:    TestFileAndIO<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestFileAndIO <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 在hello.txt的同一个文件夹下创建一个abc.txt
 */
public class Exe1
{
    public static void main(String[] args) throws IOException
    {
        File file1 = new File("hello.txt");

        File file2 = new File(file1.getAbsoluteFile().getParent(),"abc.txt");
        file2.createNewFile(); //创建文件

    }
}
