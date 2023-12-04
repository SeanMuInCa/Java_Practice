package netWork03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Purpose:             netWork02<br />
 * Data Submitted:      2023/11/30 <br />
 * Assignment Number:    netWork02<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          netWork02 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Server
{
    public static void main(String[] args)
    {
        System.out.println("Server running at 7777...");
        int count = 0;
        //1.创建套接字
        ServerSocket ss = null;
        Socket s = null;
        try
        {
            ss = new ServerSocket(7777);
            while (true){//一直监听不停
                s = ss.accept();//阻塞方法，等到数据才会继续
                count++;
                new ServerThread(s).start();
                System.out.println(count + " users request!" + s.getInetAddress());
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
