package TestThread3;

/**
 * Purpose:             TestThread3<br />
 * Data Submitted:      2024/2/19 <br />
 * Assignment Number:    TestThread3<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Account implements Runnable
{
    static String accountName = "myAccount";
    int number = 10000;
    boolean flag = true;

    public synchronized void withdraw(int amount) throws InterruptedException
    {
        if (number <= 0)
        {
            flag = false;
            return;
        }
        number -= 1000;
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName() + " " + number);

    }

    @Override
    public void run()
    {
        try
        {
            while (flag)
            {
                withdraw(1000);
            }
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)
    {
        Account t1 = new Account();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
    }
}
