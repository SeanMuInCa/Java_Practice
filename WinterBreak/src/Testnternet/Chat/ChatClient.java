package Testnternet.Chat;

import java.io.IOException;
import java.net.Socket;

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
public class ChatClient
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        //1. 连接服务器
        Socket socket = new Socket("127.0.0.1", 8888);

        //2.开启两个线程
        //1)一个线程负责接收服务器转发的消息
        Receive receive = new Receive(socket);
        receive.start();

        //2)一个线程负责发送自己说的话
        Send send = new Send(socket);
        send.start();

        send.join();//等发送线程结束，才结束

        socket.close();

    }
}
