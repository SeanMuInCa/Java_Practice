package TestIO;

import java.io.File;
import java.io.IOException;

/**
 * Purpose:             To output sum of two integers. <br />
 * To use run the main method. <br />
 * Data Submitted:      2023/11/15 <br />
 * Assignment Number:   Lab 1  <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestIO <br />
 *
 * @author Zhenghua Mu (instructor - no SDC#)
 * @version 1.0.0
 */
public class Test01
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("src/1232.txt");
        File file1 = new File("src"+File.separator+"1232.txt");//可以跨平台
        File file2 = new File("src\\1232.txt");

        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file.length());
        System.out.println(file.getName());
        System.out.println(file.getPath());
//        if(file.exists()){
//            file.delete();
//        }else{
//            file.createNewFile();
//        }
        System.out.println(file.equals(file1));
    }
}
