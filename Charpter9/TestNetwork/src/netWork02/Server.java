package netWork02;

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
    public static void main(String[] args) throws IOException
    {
        //1.创建套接字
        ServerSocket ss = new ServerSocket(7777);
        //2.等着客户端发信息
        Socket s = ss.accept();//阻塞方法，等到数据才会继续
        //接到这个s后，才连通
        //3.操作输入流
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        //4.读取数据
        String s1 = dis.readUTF();
        System.out.println(s1);

        //向客户端发送
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("hello to you too");

        //关闭
        dos.close();
        os.close();
        dis.close();
        is.close();
        s.close();
        ss.close();
    }
}
