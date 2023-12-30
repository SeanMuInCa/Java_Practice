package Testnternet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Purpose:             Testnternet<br />
 * Data Submitted:      2023/12/30 <br />
 * Assignment Number:    Testnternet<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Testnternet <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class URLtest
{
    public static void main(String[] args)
    {
        String str = "http://127.0.0.1:5500/%E6%A1%88%E4%BE%8B%E5%AE%9E%E8%AE%AD/1.%E7%80%91%E5%B8%83%E6%B5%81/index.html?name=tom";
        try
        {
            URL url = new URL(str);
            System.out.println(url.getContent());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            System.out.println(url.getProtocol());
            System.out.println(url.getQuery());
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
}
