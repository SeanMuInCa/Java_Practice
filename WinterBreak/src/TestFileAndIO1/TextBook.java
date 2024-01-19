package TestFileAndIO1;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
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
        String str1, str2 = null;
        File sourceFile = new File("d:\\test\\a.txt");
        try( Scanner input = new Scanner(sourceFile) )
        {
           while (input.hasNext())
           {
               str1 = input.nextLine();
               str2 = str1.replaceAll("abc","raina");

           }
            boolean delete = sourceFile.delete();
            System.out.println(delete);
           /*input.close();
           PrintWriter output = new PrintWriter(sourceFile);
           output.println(str2);*/
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
