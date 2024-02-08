package Assign2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Purpose:             Assign2<br />
 * Data Submitted:      2024/2/8 <br />
 * Assignment Number:    Assign2<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Assign2 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class FileIOPractice
{
    public static void loadCSV(String path)
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(new File("Apples.csv0")));
            String oneLineData = "";
            br.readLine();
            while ((oneLineData = br.readLine()) != null)
            {

            }
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }finally
        {
            if(br != null)
            {
                try
                {
                    br.close();
                } catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
