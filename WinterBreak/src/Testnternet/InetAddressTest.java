package Testnternet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Purpose:             Testnternet<br />
 * Data Submitted:      2023/12/29 <br />
 * Assignment Number:    Testnternet<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Testnternet <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class InetAddressTest
{
    public static void main(String[] args)
    {
        //1.实例化
        try
        {
            InetAddress host = InetAddress.getByName("localhost");
            InetAddress google = InetAddress.getByName("www.google.com");
            //本地ip
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(host);
            System.out.println(localHost);
            System.out.println(google);

            //常用方法
            System.out.println(google.getHostName());
            System.out.println(google.getHostAddress());
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }

    }
}
