package TestThreadCommicate;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Purpose:             TestThreadCommicate<br />
 * Data Submitted:      2023/12/16 <br />
 * Assignment Number:    TestThreadCommicate<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThreadCommicate <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 轮番打印
 */
public class PrintNumber
{
    public static void main(String[] args)
    {
        Printer p = new Printer();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        t1.start();
        t2.start();
    }
}

class Printer implements Runnable
{
    private int number = 100;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (this)
            {
                //必须有同步监视器才能用这两个方法
                notify();//不能用lock,要用lock的其他实现类里有类似的方法
                if (number > 0)
                {
                    try
                    {
                        Thread.sleep(100);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + number--);
                    try
                    {
                        wait();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                } else break;
            }
        }
    }
}