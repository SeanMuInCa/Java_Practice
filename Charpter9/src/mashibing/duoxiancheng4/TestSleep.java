package mashibing.duoxiancheng4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Purpose:             mashibing.duoxiancheng4<br />
 * Data Submitted:      2023/11/29 <br />
 * Assignment Number:    mashibing.duoxiancheng4<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.duoxiancheng4 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestSleep
{
    public static void main(String[] args) throws InterruptedException
    {
        /*try
        {
            Thread.sleep(2000);//类似于settimeout，延迟了2秒再执行后面的
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("i love java");//立即输出*/
        Date d;
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        while (true) {
            d = new Date();
            System.out.println(df.format(d));
            Thread.sleep(1000);
        }
    }
}
