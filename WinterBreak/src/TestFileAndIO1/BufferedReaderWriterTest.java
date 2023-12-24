package TestFileAndIO1;

import org.junit.Test;

import java.io.*;

/**
 * Purpose:             TestFileAndIO1<br />
 * Data Submitted:      2023/12/23 <br />
 * Assignment Number:    TestFileAndIO1<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestFileAndIO1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class BufferedReaderWriterTest
{
    @Test
    public void test(){
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try
        {
            File file1 = new File("d:\\Java\\test.txt");
            fr = new FileReader(file1);

            File file2 = new File("d:\\Java\\res_copy1.txt");
            fw = new FileWriter(file2);

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            //方式1
            /*char[] buffer = new char[1024];

            int length;
            while ((length = br.read(buffer)) != -1)
            {//这里返回的是读取的长度
                bw.write(buffer, 0, length);
            }*/
            //方式2
            String data;
            while ((data = br.readLine())!= null)
            {
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (br != null)
                    br.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if (bw != null)
                    bw.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
