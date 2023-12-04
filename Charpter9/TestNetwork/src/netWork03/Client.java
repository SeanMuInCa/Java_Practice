package netWork03;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

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
    public static void main(String[] args)
    {
        //1. 创建套接字  必须指定服务器IP和端口
        Socket socket = null;
        DataInputStream dis = null;
        InputStream is = null;
        ObjectOutputStream oos = null;
        try
        {
            socket = new Socket("localhost",7777);
            Scanner input = new Scanner(System.in);
            System.out.println("input your account name: ");
            String username = input.next();
            System.out.println("input your password");
            String pwd = input.next();
            User user = new User(username,pwd);

            System.out.println(user.getName());
            System.out.println(user.getPwd());
            //2向外发送数据 os不能直接发string，套个dos来发
            OutputStream os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(user);

            //接收服务器发来的消息
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            String line = dis.readUTF();
            System.out.println(line);
            if(line.equals("ok")){
                System.out.println("login ok!");
            }else System.out.println("login not ok");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }finally
        {
            //关闭流，关闭网络
            try
            {
                assert dis != null;
                dis.close();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            try
            {
                is.close();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            try
            {
                oos.close();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            try
            {
                socket.close();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
