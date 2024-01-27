package Lab3.Q3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Purpose:             Lab3.Q3<br />
 * Data Submitted:      2024/1/27 <br />
 * Assignment Number:    Lab3.Q3<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Lab3.Q3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class B
{
    public static void main(String[] args)
    {
        ArrayList<Person> list = new ArrayList<>();
        readFile(list,"User.data");
        printList(list);
    }

    private static void printList(ArrayList<Person> list)
    {
        for (Person p : list)
        {
            System.out.println(p);
        }

    }

    private static void readFile(ArrayList<Person> list, String s)
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(new File(s)));
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] info = line.split(",");
                Person p = new Person(info[0].trim(),info[1].trim());
                p.setAge(Integer.parseInt(info[2]));
                p.setSin(Long.parseLong(info[3]));
                list.add(p);
            }
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
