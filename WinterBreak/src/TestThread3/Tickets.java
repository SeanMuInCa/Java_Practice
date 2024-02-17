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
    //todo 这里没有解决同步问题，后续再看
    public static void main(String[] args)
    {
        SellTickets1 s1 = new SellTickets1();
        //SellTickets1 s2 = new SellTickets1();
        //SellTickets1 s3 = new SellTickets1();
        new Thread(s1).start();
        new Thread(s1).start();
        new Thread(s1).start();
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