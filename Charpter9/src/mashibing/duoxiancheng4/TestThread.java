package mashibing.duoxiancheng4;

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
public class TestThread extends Thread
{
    @Override
    public void run()
    {
        for (int i = 1; i <= 1000 ; i++)
        {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}
