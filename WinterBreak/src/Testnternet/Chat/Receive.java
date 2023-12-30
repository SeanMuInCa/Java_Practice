package Testnternet.Chat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Purpose:             Testnternet.Chat<br />
 * Data Submitted:      2023/12/30 <br />
 * Assignment Number:    Testnternet.Chat<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Testnternet.Chat <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Receive extends Thread
{
    private Socket socket;
    public Receive(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            InputStream in = socket.getInputStream();
            //接收服务端通知

            ByteArrayOutputStream baos = new ByteArrayOutputStream();//用这个防止中文
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer))!= -1)
            {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos);
            /*Scanner input = new Scanner(in);

            while (input.hasNextLine()){
                String str = input.nextLine();
                System.out.println(str);
            }*/
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
