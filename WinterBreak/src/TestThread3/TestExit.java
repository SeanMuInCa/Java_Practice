package TestThread3;

/**
 * Purpose:             TestThread3<br />
 * Data Submitted:      2024/2/17 <br />
 * Assignment Number:    TestThread3<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestExit
{
    public static void main(String[] args)
    {

        Runnable t1 = () ->
        {
            int n = 0;
            boolean flag = true;
            while (flag)
            {
                System.out.println(Thread.currentThread().getName() + n++);
                try
                {
                    Thread.sleep(50);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(t1).start();

    }
}
