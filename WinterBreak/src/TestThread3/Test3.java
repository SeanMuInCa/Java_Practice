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
public class Test3
{
    public static void main(String[] args)
    {
        Runnable t1 = () ->
        {
            int n = 10;
            while (n > 0)
            {
                System.out.println(Thread.currentThread().getName() + " Hello " + n--);
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable t2 = ()->{
            int n = 5;
            while (n > 0)
            {
                System.out.println(Thread.currentThread().getName() + " hi " + n--);
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
