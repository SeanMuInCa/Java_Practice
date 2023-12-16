package TestThread1;

import java.util.Stack;

/**
 * Purpose:             TestThread1<br />
 * Data Submitted:      2023/12/16 <br />
 * Assignment Number:    TestThread1<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 单例模式线程安全
 */
public class Exe3
{
    public static void main(String[] args)
    {
        Bank[] banks = new Bank[2];
        Thread t1 = new Thread()
        {
            @Override
            public void run()
            {
                banks[0] = Bank.getInstance();
            }
        };

        Thread t2 = new Thread()
        {
            @Override
            public void run()
            {
                banks[1] = Bank.getInstance();
            }
        };
        t1.start();
        t2.start();

        try
        {
            t1.join();//等待线程结束
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            t2.join();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println(banks[0]);
        System.out.println(banks[1]);
        System.out.println(banks[0] == banks[1]);
    }
}

class Bank
{
    private Bank()
    {
    }

    private static volatile Bank instance = null;//避免指令重排

    public static /*synchronized*/ Bank getInstance()
    {
//        System.out.println(Thread.currentThread().getName());
        if (instance == null)//最安全的一种方式，后续线程不需要再进入判断
        {
            synchronized (Bank.class)
            {
                if (instance == null)
                {
                    try
                    {
                        Thread.sleep(1000);
                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                    instance = new Bank();
                }

            }
        }
        return instance;
    }
}
