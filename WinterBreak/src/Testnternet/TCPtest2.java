package Testnternet;

import org.junit.Test;

import java.io.*;
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
 * 客户端发文件，服务器端保存文件
 */
public class TCPtest2
{
    @Test
    public void client(){
        Socket clientSocket = null;
        FileInputStream fis = null;
        OutputStream ops = null;
        try
        {
            //创建一个socket对象
            clientSocket = new Socket(InetAddress.getLocalHost(),8989);
            File src = new File("d:\\Java\\原型链.png");
            fis = new FileInputStream(src);
            ops = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1)
            {
                ops.write(buffer,0,len);
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }finally
        {
            try
            {
                if (ops != null)
                {
                    ops.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            try
            {
                if (fis != null)
                {
                    fis.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            try
            {
                if (clientSocket != null)
                {
                    clientSocket.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }

    }
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        FileOutputStream fos = null;
        try
        {
            serverSocket = new ServerSocket(8989);
            socket = serverSocket.accept();
            InputStream is = socket.getInputStream();

            File dst = new File("d:\\a.png");
            fos = new FileOutputStream(dst);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer))!= -1)
            {
                fos.write(buffer,0,len);
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }
}
