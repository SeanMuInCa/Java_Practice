package TestFileAndIO1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Purpose:             TestFileAndIO1<br />
 * Data Submitted:      2024/3/21 <br />
 * Assignment Number:    TestFileAndIO1<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          TestFileAndIO1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestRandomAccess
{
    public static void main(String[] args)
    {
        try(
                RandomAccessFile operator = new RandomAccessFile("1.txt", "rw");
                )
        {
            operator.writeUTF("Hello word");
            //operator.seek(operator.length());
            operator.writeUTF("nihao");
            operator.writeInt(000);
        }catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
