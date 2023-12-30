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
        BufferedInputStream bis = null;
        OutputStream ops = null;
        try
        {
            //创建一个socket对象
            clientSocket = new Socket(InetAddress.getLocalHost(),8989);
            File src = new File("d:\\Java\\原型链.png");
            fis = new FileInputStream(src);
            bis = new BufferedInputStream(fis);
            ops = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1)
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
                if (bis != null)
                {
                    bis.close();
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
        BufferedOutputStream bos = null;
        InputStream is = null;
        try
        {
            serverSocket = new ServerSocket(8989);
            socket = serverSocket.accept();
            is = socket.getInputStream();

            File dst = new File("d:\\a.png");
            fos = new FileOutputStream(dst);
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer))!= -1)
            {
                bos.write(buffer,0,len);
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }finally
        {
            try
            {
                bos.close();
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
                socket.close();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            try
            {
                serverSocket.close();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
