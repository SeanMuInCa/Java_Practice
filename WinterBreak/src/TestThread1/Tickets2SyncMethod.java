package TestThread1;

/**
 * Purpose:             TestThread1<br />
 * Data Submitted:      2023/12/15 <br />
 * Assignment Number:    TestThread1<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Tickets2SyncMethod
{
    public static void main(String[] args)
    {
        Sale4 t1 = new Sale4();
        Sale4 t2 = new Sale4();
        Sale4 t3 = new Sale4();
        t1.start();
        t2.start();
        t3.start();

    }
}

class Sale4 extends Thread
{
    static int tickets = 10;

    static boolean flag = true;
    @Override
    public void run()
    {
        while (flag)
        {
            buyT();
        }
    }
    public static synchronized void buyT(){//不是每个方法都能这么做，这个要看这个方法是不是可以是静态
        if (tickets > 0)
        {
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " got " + tickets);
            tickets--;
        } else
        {
           flag = false;
        }
    }
}
