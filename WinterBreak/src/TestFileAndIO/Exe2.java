package TestFileAndIO;

import java.io.File;
import java.io.FilenameFilter;

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
public class Exe2
{
    public static void main(String[] args)
    {
        FilenameFilter filter = new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.contains(".txt");
            }
        };
        File file = new File("d:\\Java");
        String[] list = file.list(filter);
        for (String s : list)
        {
            System.out.println(s);
        }

    }
}
