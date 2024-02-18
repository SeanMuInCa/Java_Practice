package TestThread3;

/**
 * Purpose:             TestThread3<br />
 * Data Submitted:      2024/2/18 <br />
 * Assignment Number:    TestThread3<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestDaemon
{
    public static void main(String[] args) throws InterruptedException
    {
        Runnable t1 = ()->{
            while (true)
            {
                try
                {
                    Thread.sleep(50);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.println("hello");
            }
        };
        Thread thread = new Thread(t1);
        thread.setDaemon(true);//设置为守护线程，这样当主线程结束后，子线程也结束
        thread.start();

        for (int i = 0; i < 10; i++)
        {
            System.out.println(i);
            Thread.sleep(50);
        }
    }
}
