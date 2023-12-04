package netWork02;

import java.io.*;
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
public class Client
{
    public static void main(String[] args) throws IOException
    {
        //1. 创建套接字  必须指定服务器IP和端口
        Socket socket = new Socket("localhost",7777);
        //2向外发送数据 os不能直接发string，套个dos来发
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("hello");

        //接收服务器发来的消息
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        System.out.println(dis.readUTF());

        //关闭流，关闭网络
        dis.close();
        is.close();
        dos.close();
        socket.close();
    }
}
