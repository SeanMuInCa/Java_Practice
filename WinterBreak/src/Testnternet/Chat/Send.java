package Testnternet.Chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
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
public class Send extends Thread
{
    private Socket socket;

    public Send(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            Scanner input = new Scanner(System.in);
            OutputStream out = socket.getOutputStream();
            //按行打印
            PrintStream ps = new PrintStream(out);

            //输入并发送给服务器，由服务器转发给其他人
            while (true)
            {
                String str = input.nextLine();
                if (("886").equals(str))
                {
                    ps.println(str);
                    break;
                }
                ps.println(str);
            }
            input.close();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
