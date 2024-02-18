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
public class TestJoinYield
{
    public static void main(String[] args) throws InterruptedException
    {
        Runnable t1 = ()->{
            for (int i = 0; i < 20; i++)
            {
                System.out.println("hello " + i);
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread1 = new Thread(t1);
        thread1.start();
        for (int i = 0; i < 20; i++)
        {
            System.out.println("hi " + i);
            if(i == 4)
            {
                thread1.join();
            }
        }
    }
}
