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
        t1.start();
        for (int i = 0; i < 10; i++)
        {
            System.out.println(i);
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
                System.out.println(Thread.currentThread().getName() + (n + 1));
                Thread.sleep(1000);
            }
            System.out.println("finish");
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}