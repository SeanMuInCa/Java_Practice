package TestFileAndIO1;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Purpose:             TestFileAndIO1<br />
 * Data Submitted:      2024/1/18 <br />
 * Assignment Number:    TestFileAndIO1<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestFileAndIO1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TextBook
{
    @Test
    public void test1(){
        File sourceFile = new File("d:\\test\\a.txt");
        File targetFile = new File("d:\\test\\b.txt");
        try( Scanner input = new Scanner(sourceFile);
             PrintWriter output = new PrintWriter(targetFile);)
        {
           while (input.hasNext())
           {
               String str1 = input.nextLine();
               String str2 = str1.replaceAll("abc","raina");
               output.println(str2);
           }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
