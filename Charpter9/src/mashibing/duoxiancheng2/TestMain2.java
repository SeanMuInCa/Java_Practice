package mashibing.duoxiancheng2;

/**
 * Purpose:             mashibing.duoxiancheng2<br />
 * Data Submitted:      2023/11/26 <br />
 * Assignment Number:    mashibing.duoxiancheng2<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.duoxiancheng2 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestMain2
{
    public static void main(String[] args)
    {
        TestThread2 tt = new TestThread2();
        Thread t = new Thread(tt);
        t.start();
        for (int i = 0; i < 10; i++)
        {
            System.out.println(Thread.currentThread().getName() + "---"+i);
        }
    }
}
