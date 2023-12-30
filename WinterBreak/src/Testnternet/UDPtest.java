package Testnternet;

import org.junit.Test;

import java.net.*;
import java.util.Arrays;

/**
 * Purpose:             Testnternet<br />
 * Data Submitted:      2023/12/30 <br />
 * Assignment Number:    Testnternet<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Testnternet <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class UDPtest
{
    @Test
    public void sender() throws Exception
    {
        //1. 创建socket实例DatagramSocket
        DatagramSocket ds = new DatagramSocket();

        //2. 整理数据
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 8989;
        String str = "hello world";
        byte[] bytes = str.getBytes();

        //3. 打包数据
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, inetAddress, port);
        //4发送数据
        ds.send(packet);

        ds.close();
    }
    @Test
    public void receiver() throws Exception
    {
        int port = 8989;
        //1. 创建socket实例DatagramSocket
        DatagramSocket ds = new DatagramSocket(port);

        //2.定义一个接收容器
        byte[] msg = new byte[1024];
        DatagramPacket packet = new DatagramPacket(msg, msg.length);

        //3接收
        ds.receive(packet);

        //4获取数据并打印
        String str = new String(packet.getData(), 0, packet.getLength());
        System.out.println(str);
        ds.close();

    }
}
