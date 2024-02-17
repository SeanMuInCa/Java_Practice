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
                        System.out.println(n--);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable t2 = () -> {
            try
            {
                int n = 10;
                while (n-- > 0)
                {
                    System.out.println(n + 1);
                    Thread.sleep(1000);
                }
                System.out.println("finish");
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        };
        t2.run();
    }
}
