package TestThread2;

/**
 * Purpose:             TestThread2<br />
 * Data Submitted:      2024/2/15 <br />
 * Assignment Number:    TestThread2<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread2 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Test
{
    public static void main(String[] args)
    {
        Runnable t1 = ()-> {
            for (int i = 0; i < 10; i++)
            {
                System.out.println(Thread.currentThread().getName() + i);
            }
        };
        Thread thread = new Thread(t1);
        thread.start();
        Thread thread1 = new Thread(t1);
        thread1.start();
        Thread thread2 = new Thread(thread);
        thread2.start();
        for (int i = 0; i < 10; i++)
        {
            System.out.println(Thread.currentThread().getName() + i);
            System.out.println(Thread.currentThread().isAlive());
        }
        System.out.println(Thread.currentThread().isAlive());
    }
}
