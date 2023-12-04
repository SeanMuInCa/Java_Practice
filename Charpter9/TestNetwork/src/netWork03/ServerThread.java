package netWork03;

import java.io.*;
import java.net.Socket;

/**
 * Purpose:             netWork03<br />
 * Data Submitted:      2023/12/1 <br />
 * Assignment Number:    netWork03<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          netWork03 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
//处理客户端请求的线程，可以处理多个请求了，并且不会请求完服务器就关掉了
public class ServerThread extends Thread
{
    public ServerThread(Socket s)
    {
        this.s = s;
    }

    InputStream is = null;
    ObjectInputStream ois = null;
    OutputStream os = null;
    DataOutputStream dos = null;
    Socket s = null;
    @Override
    public void run()
    {
        try {
            //2.等着客户端发信息

            //接到这个s后，才连通
            //3.操作输入流
            is = s.getInputStream();
//        DataInputStream dis = new DataInputStream(is);
            ois = new ObjectInputStream(is);
            //4.读取数据
            User user = (User)(ois.readObject());
            os = s.getOutputStream();
            dos = new DataOutputStream(os);;
            System.out.println(user.getName());
//        dos.writeUTF("ok");
            if("raina".equals(user.getName())){
                dos.writeUTF("ok");
            }else{
                dos.writeUTF("nook");
            }
        } catch (IOException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }finally
        {
            //关闭
            try
            {
                if (dos != null)
                {
                    dos.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            try
            {
                if (os != null)
                {
                    os.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            try
            {
                if (ois != null)
                {
                    ois.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            try
            {
                if (is != null)
                {
                    is.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
