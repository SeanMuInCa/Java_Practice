package TestFileAndIO;

import java.io.File;
import java.util.function.Predicate;

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
 * 1.遍历指定文件目录下所有文件的名称，包括子目录中的文件
 * 2.删除指定文件目录以及子目录中的所有文件
 * 3.计算指定文件夹的大小
 */
public class KeyExe3
{
    public static void main(String[] args)
    {
        File file1 = new File("D:\\迅雷下载");
        File file2 = new File("D:\\test");
//        System.out.println(file.getAbsolutePath());
        printFileName(file1);
//        deleteDir(file2);
        System.out.println(getDirectorySize(file1));
    }
    public static void printFileName(File file){
        if(file.isFile()){
            System.out.println(file.getName());
        }
        if(file.isDirectory()){
            File[] list = file.listFiles();
            for(File f : list){
                printFileName(f);
            }
        }
    }
    public static void deleteDir(File file){

        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                deleteDir(f);
            }
        }
        System.out.println(file.delete() ? "deleted!" : "failed");
    }
    public static long getDirectorySize(File file){
        long size = 0;
        if(file.isFile()){
            size = file.length();
        }
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                size += getDirectorySize(f);//这样可以累加
            }
        }
        return size;
    }
}
