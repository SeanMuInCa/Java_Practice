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
        Runnable t2 = ()->{
            int n = 10;
            while (n-- > 0)
            {
                try
                {
                    Thread.sleep(50);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.println("hi");
            }
        };
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);
        thread.setDaemon(true);//设置为守护线程，这样当主线程结束后，子线程也结束
        thread1.setDaemon(true);//设置为守护线程，这样当主线程结束后，子线程也结束
        thread.start();
        thread1.start();

        for (int i = 0; i < 50; i++)
        {
            System.out.println(i);
            Thread.sleep(50);
        }
    }
}
