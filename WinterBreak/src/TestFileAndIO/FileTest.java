package TestFileAndIO;

import com.sun.tools.javac.Main;
import org.junit.Test;

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
 */
public class FileTest
{
    /*
    * File(String path)
    * File(String parent, String child)
    * File(File parent, String child)
    * */
    @Test
    public void test(){
        //File(String path)
        File file1 = new File("test.txt");
        System.out.println(file1.getAbsolutePath());

        File file2 = new File("test");//folder
        System.out.println(file2.getAbsolutePath());
    }
    @Test
    public void test1(){
        //File(String parent, String child)
        File file1 = new File("d:\\io","test.txt");
        File file2 = new File("io","test");

        //File(File parent, String child)
        File file3 = new File(file2, "test.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file3.getAbsolutePath());
    }
    @Test
    public void test2(){
        /*methods
        * getName
        * getPath
        * getAbsolutePath
        * getAbsoluteFile  file by absolute path
        * getParent parent folder
        * length for file, it's the size of file, for folder it's zero
        * lastModified last modified time in milliseconds
        * */
        File file = new File("d:\\io","test.txt");
        File file1 = new File("\\test\\test.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        System.out.println("--------------");
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
    }
    
    @Test
    public void test3(){
        //String[] list() return all the files in the folder as a string array
        //File[] listFiles() return all the files in the folder as a file array
        File file1 = new File("d:\\Java");
        for (String s : file1.list())
        {
            System.out.println(s);
        }
        System.out.println("-------------------");
        File file2 = new File("d:\\Java");
        for (File s : file2.listFiles())
        {
            System.out.println(s);
        }

    }
    @Test
    public void test4(){
        //renameTo(File dest) 如果要成功，file1必须存在，且file2不存在
        File file1 = new File("d:\\Java","test.txt");
        File file2 = new File("d:\\Java","test1.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b ? "work!" : "failed");
    }
    @Test
    public void test5(){
        /*more methods
        * exists()
        * isDirectory()
        * isFile()
        * canRead()
        * canWrite()
        * isHidden()
        * */
        File file1 = new File("d:\\Java","test.txt");
        File file2 = new File("abc");
        System.out.println(file1.exists());
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

    }

    @Test
    public void test6() throws IOException
    {
        /*
        * createNewFile()
        * mkdir()
        * mkdirs()
        * delete()
        * */
        File file1 = new File("d:\\Java","test.txt");
        System.out.println(file1.createNewFile());
    }
}
