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
public class Test2
{
    public static void main(String[] args) throws InterruptedException
    {
        Some t1 = new Some();
        Runnable t23 = () ->
        {
            int n = 10;
            while (n-- > 0)
            {
                System.out.println(Thread.currentThread().getName() + " " + (n + 1));
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        };
        t1.start();//真正意义上的多线程
        Some1 t2 = new Some1();
        new Thread(t2).start();//包了一层
        new Thread(t23).start();//包了一层
        for (int i = 0; i < 10; i++)
        {
            System.out.println(Thread.currentThread().getName() + i);
            Thread.sleep(1000);
        }
    }
}

class Some extends Thread
{
    @Override
    public void run()
    {
        try
        {
            int n = 10;
            while (n-- > 0)
            {
                System.out.println(Thread.currentThread().getName() +" " + (n + 1));
                Thread.sleep(1000);
            }
            System.out.println("finish");
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
class Some1 implements Runnable
{
    @Override
    public void run()
    {
        int n = 10;
        while (n-- > 0)
        {
            System.out.println(Thread.currentThread().getName() + " " + (n + 1));
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}