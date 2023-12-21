package TestMap;

import org.junit.Test;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/**
 * Purpose:             TestMap<br />
 * Data Submitted:      2023/12/21 <br />
 * Assignment Number:    TestMap<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestMap <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * properties 只能存字符串的key-value
 */
public class TestProperties
{
    @Test
    public void test(){
        Properties properties = new Properties();
        properties.put("zhenghua", "mu");
        properties.put("raina", "mu");
        properties.put("fiona", "ruan");

        Iterator it = properties.entrySet().iterator();;
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test
    public void test1() throws IOException
    {
        File file = new File("abc.txt");
        FileInputStream in = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(in);

        System.out.println(prop.size());
        Iterator it = prop.entrySet().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
