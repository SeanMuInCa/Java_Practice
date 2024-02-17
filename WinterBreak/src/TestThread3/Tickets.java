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
    public static void main(String[] args)
    {
        SellTickets1 s1 = new SellTickets1();
        //SellTickets1 s2 = new SellTickets1();
        //SellTickets1 s3 = new SellTickets1();
        new Thread(s1).start();
        new Thread(s1).start();
        new Thread(s1).start();
    }
}
class SellTickets extends Thread
{
    private static int num = 10;

    @Override
    public void run()
    {
        while (num > 0)
        {
            System.out.println("Counter " + Thread.currentThread().getName() + " " + (num--));
            try
            {
                Thread.sleep(50);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
class SellTickets1 implements Runnable
{
    private int num = 10;
    @Override
    public void run()
    {
        while (num > 0)
        {
            System.out.println("Counter " + Thread.currentThread().getName() + " " + (num--));
            try
            {
                Thread.sleep(50);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}