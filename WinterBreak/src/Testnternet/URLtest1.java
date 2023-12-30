package Testnternet;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
public class URLtest1
{
    @Test
    public void test() throws Exception
    {
        //获取实例
        URL url = new URL("http://127.0.0.1:5500/%E6%A1%88%E4%BE%8B%E5%AE%9E%E8%AE%AD/1.%E7%80%91%E5%B8%83%E6%B5%81/img/1.jpg");
        //建立连接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //读入数据
        InputStream is = conn.getInputStream();
        //输出文件
        File file = new File("d:\\b.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1)
        {
            fos.write(buffer, 0, len);
        }
        fos.close();
        is.close();
        conn.disconnect();
    }
}
