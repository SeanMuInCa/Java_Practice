package TestThread3;

import org.junit.Test;

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
public class Test1
{
    @Test
    public void test(){

        Runnable t1 = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    int n = 10;
                    while (n > 0)
                    {
                        System.out.println(Thread.currentThread().getName());
                        n--;
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        };

        Runnable t2 = () -> {
            try
            {
                int n = 10;
                while (n-- > 0)
                {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
                System.out.println("finish");
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        };
        /*t2.run();
        t1.run();
        //这样根本不是多线程，不能直接调用run，否则都是主线程在调用，变成串行方式了*/
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
