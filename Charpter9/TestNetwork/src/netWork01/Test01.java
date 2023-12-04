package netWork01;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
public class Test01
{
    public static void main(String[] args) throws UnknownHostException
    {
        //封装IP
//        InetAddress ip = new InetAddress();不能直接创建，default修饰符
        InetAddress ia = InetAddress.getByName("127.0.0.2");
        System.out.println(ia);
        InetAddress ia2 = InetAddress.getByName("Localhost");
        System.out.println(ia2);
        InetAddress ia3 = InetAddress.getByName("Sean");
        System.out.println(ia3);
        InetAddress ia4 = InetAddress.getByName("www.google.com");
        System.out.println(ia4);

        System.out.println(ia4.getHostName());
        System.out.println(ia4.getHostAddress());
        System.out.println(ia4.isAnyLocalAddress());

    }
}
