package Testnternet.Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
public class ChatServer
{
    //存储所有在线的客户端的集合
    static ArrayList<Socket> onlineClients = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        //1启动服务器，绑定端口号
        ServerSocket serverSocket = new ServerSocket(8888);

        //2接收N个客户端的连接
        while (true){
            Socket socket = serverSocket.accept();

            //添加新的客户端
            onlineClients.add(socket);

            //这个分线程负责接收消息并分发消息
            MessageHandler messageHandler = new MessageHandler(socket);
            messageHandler.start();//启动接收线程
        }
    }
    static class MessageHandler extends Thread{
        private Socket socket;
        private String ip;
        public MessageHandler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run()
        {
            try
            {
                ip = socket.getInetAddress().getHostAddress();

                //给其他客户端发”我上线了“通知
                sendToOther(ip + "我上线了");

                //1接收该客户端发送的消息
                InputStream inputStream = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(isr);

                String str;
                while ((str = br.readLine()) != null){
                    //2给其他在线客户端转发
                    sendToOther(ip + " : " + str);
                }
                sendToOther(ip + "下线了");
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }finally
            {
                //移除下线的客户端
                onlineClients.remove(socket);
            }
        }
        public void sendToOther(String msg){
            for(Socket socket : onlineClients){
                try
                {
                    OutputStream os = socket.getOutputStream();
                    PrintStream ps = new PrintStream(os);
                    ps.println(msg);
                } catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
