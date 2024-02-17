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
        SellTickets s1 = new SellTickets();
        SellTickets s2 = new SellTickets();
        SellTickets s3 = new SellTickets();
        s1.start();
        s2.start();
        s3.start();
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