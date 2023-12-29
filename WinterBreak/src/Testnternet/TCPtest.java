package Testnternet;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

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
    //客户端发送内容给服务器，服务端将内容打印到控制台
    Socket clientSocket = null;
    OutputStream msg = null;

    @Test
    public void client(){
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
        //创建一个socket对象
        try
        {
            serverSocket = new ServerSocket(8989);
            //接收socket
            Socket socket = serverSocket.accept();
            //接收数据
            InputStream msg = socket.getInputStream();
            System.out.println(msg.read());
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
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }





    }
}
