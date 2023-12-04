package mashibing.TestUDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Purpose:             mashibing.TestUDP<br />
 * Data Submitted:      2023/12/3 <br />
 * Assignment Number:    mashibing.TestUDP<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.TestUDP <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestSender
{
    public static void main(String[] args)
    {
        System.out.println("发送者上线");
        //1.准备套接字
        DatagramSocket ds = null;
        try
        {
            ds = new DatagramSocket(7777);
            while (true)
            {
                //2.准备数据包
                Scanner input = new Scanner(System.in);
                System.out.println("input message to receiver: ");
                String str = input.nextLine();
                byte[] bytes = str.getBytes();
                /*
                 * 四个参数
                 * 1. 传送数据转化为字节数组
                 * 2. 字节数组的长度
                 * 3. 封装接收方IP
                 * 4. 接收方的端口号
                 *
                 * */
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 9999);

                //发送
                ds.send(dp);
                if(str.equals("byebye")){
                    System.exit(1);
                }
                //2. 准备数据接收，先定义一个空的数据包，打算用来接收
                byte[] data = new byte[1024];
                DatagramPacket dp1 = new DatagramPacket(data, data.length);

                //3. 接收数据，并存在DATA里
                ds.receive(dp1);

                //4取出数据
                byte[] data1 = dp1.getData();
                String msg = new String(data1, 0, dp1.getLength());
                System.out.println(msg);
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            //关闭资源
            assert ds != null;
            ds.close();
        }
    }
}
