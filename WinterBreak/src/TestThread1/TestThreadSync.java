package TestThread1;

/**
 * Purpose:             TestThread1<br />
 * Data Submitted:      2023/12/16 <br />
 * Assignment Number:    TestThread1<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestThreadSync
{
    public static void main(String[] args)
    {
        Sale2 t1 = new Sale2();

        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
    }

}

class Sale2 implements Runnable
{
    int tickets = 10;

    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(5);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            synchronized (this){

                if (tickets > 0)
                {
                    /*try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }*/
                    System.out.println(Thread.currentThread().getName() + " got " + tickets);
                    tickets--;
                } else
                {
                    break;
                }
            }
        }
    }
}