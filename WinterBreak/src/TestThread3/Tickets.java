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
public class Tickets
{

    public static void main(String[] args) throws InterruptedException
    {
        SellTickets1 s1 = new SellTickets1();
        //SellTickets1 s2 = new SellTickets1();
        //SellTickets1 s3 = new SellTickets1();
        Thread thread = new Thread(s1);

        Thread thread1 = new Thread(s1);

        Thread thread2 = new Thread(s1);
        thread.start();
        thread1.start();
        thread2.start();

        //都会出现问题，不管是继承方式，还是接口方式
        //必须要加锁才能解决这个问题
    }
}

class SellTickets extends Thread
{
    private static int num = 10;

    @Override
    public void run()
    {
        while (true)
        {
            buy();
        }
    }

    public synchronized void buy()
    {
        if (num < 0) return;
        System.out.println("Counter " + Thread.currentThread().getName() + " " + (num));
        num--;
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}

class SellTickets1 implements Runnable
{
    private int num = 100;
    boolean flag = true;

    @Override
    public void run()
    {
        while (flag)
        {
            buy();
        }

    }

    public synchronized void buy()
    {
        if (num <= 0)
        {
            flag = false;
            return;
        }
        System.out.println("Counter " + Thread.currentThread().getName() + " " + (num--));
        try
        {
            Thread.sleep(50);
            //Thread.yield();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}