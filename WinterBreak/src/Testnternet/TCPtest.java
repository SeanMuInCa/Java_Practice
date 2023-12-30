package Testnternet;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

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
public class TCPtest
{


    @Test
    public void client(){
        //客户端发送内容给服务器，服务端将内容打印到控制台
        Socket clientSocket = null;
        OutputStream msg = null;
        try
        {
            //创建一个socket对象
            clientSocket = new Socket(InetAddress.getLocalHost(),8989);
            //发送数据
            msg = clientSocket.getOutputStream();
            msg.write("hello".getBytes());
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            //关闭socket
            try
            {
                clientSocket.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                msg.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }


    }
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream msg = null;
        //创建一个socket对象
        try
        {
            serverSocket = new ServerSocket(8989);
            //接收socket
            socket = serverSocket.accept();
            //接收数据
            msg = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = msg.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.println(str);
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }finally
        {
            //关闭socket
            try
            {
                if(msg!=null)
                    msg.close();
                if (serverSocket != null)
                {
                    serverSocket.close();
                }
                if (socket != null)
                {
                    socket.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
