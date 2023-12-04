package mashibing.TestUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
public class TestReceiver
{
    public static void main(String[] args)
    {
        System.out.println("接收方上线");
        //1. 准备套接字 接收方端口
        DatagramSocket ds = null;
        try
        {
            ds = new DatagramSocket(9999);
            while (true)
            {
                //2. 准备数据接收，先定义一个空的数据包，打算用来接收
                byte[] data = new byte[1024];
                DatagramPacket dp = new DatagramPacket(data, data.length);

                //3. 接收数据，并存在DATA里
                ds.receive(dp);

                //4取出数据
                byte[] data1 = dp.getData();
                String msg = new String(data1, 0, dp.getLength());
                System.out.println(msg);
                if(msg.equals("byebye")){
                    System.exit(1);
                }

                //5. 回复发送者
                System.out.println("input your reply: ");
                Scanner input = new Scanner(System.in);
                String str = input.nextLine();
                byte[] data2 = str.getBytes();
                DatagramPacket dp1 = new DatagramPacket(data2, data2.length, InetAddress.getByName("localhost"), 7777);
                ds.send(dp1);
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            //关闭
            assert ds != null;
            ds.close();
        }
    }
}
