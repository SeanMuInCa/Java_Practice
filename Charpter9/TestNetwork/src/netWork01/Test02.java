package netWork01;

import java.net.InetSocketAddress;

/**
 * Purpose:             netWork01<br />
 * Data Submitted:      2023/11/30 <br />
 * Assignment Number:    netWork01<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          netWork01 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Test02
{
    public static void main(String[] args)
    {
        //封装了端口号
        InetSocketAddress addr = new InetSocketAddress("www.google.com",443);
        System.out.println(addr);

    }
}
