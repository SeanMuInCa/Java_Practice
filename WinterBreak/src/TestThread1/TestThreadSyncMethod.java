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
public class TestThreadSyncMethod
{
    public static void main(String[] args)
    {
        Sale3 t1 = new Sale3();

        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
    }

}

class Sale3 implements Runnable
{
    int tickets = 10;
    boolean flag = true;
    public void run()
    {
        while (flag)
        {
            buy();
        }
    }
    public synchronized void buy(){
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
        }else{
            flag = false;
        }

    }
}