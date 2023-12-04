package TestIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Purpose:             <br />
 * Data Submitted:      2023/11/15 <br />
 * Assignment Number:    <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestIO <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class CopyFile
{
    public static void main(String[] args) throws IOException
    {
        //关联文件
        File f = new File("src/Before Sunset1.txt");
        //关联文件读取流
        FileReader fr = new FileReader(f);
        //读取文件
        //1. 一个字符一个字符读取
        /*int n;
        while ((n=fr.read()) != -1){//读取完的时候，就会读到-1，这里必须赋值一次，不然直接用会多次读取
            System.out.println(n);
        }*/
        /*2. 多个字符一次性读取
        * */
        long start = System.currentTimeMillis();
        char[] ch = new char[256];
        int length;
        String str = "";
        while ((length = fr.read(ch)) != -1){
            /*for (int i = 0; i < length; i++)
            {
                System.out.println(ch[i]);
            }*/
            str += new String(ch,0,length);
        }
//        System.out.println(str);

        //创建文件
        File tempFile = new File("src/temp.txt");//自动创建文件
//        if(!tempFile.exists()) tempFile.createNewFile();
        FileWriter fileWriter = new FileWriter(tempFile,false);//false就会覆盖，true是追加
        //写入str
        fileWriter.write(str);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //关闭写入流。关闭时候，倒着关闭
        fileWriter.close();
        //关闭读取
        fr.close();
    }
}
