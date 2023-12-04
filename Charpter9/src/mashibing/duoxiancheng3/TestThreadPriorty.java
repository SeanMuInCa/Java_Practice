package mashibing.duoxiancheng3;

/**
 * Purpose:             mashibing.duoxiancheng3<br />
 * Data Submitted:      2023/11/26 <br />
 * Assignment Number:    mashibing.duoxiancheng3<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.duoxiancheng3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestThreadPriorty extends Thread
{
    @Override
    public void run()
    {
        for (int i = 1; i <= 10; i++)
        {
            System.out.println(Thread.currentThread().getName()+"->"+i);
        }
    }
}
