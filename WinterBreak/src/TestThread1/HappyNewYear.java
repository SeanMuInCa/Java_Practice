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
public class HappyNewYear
{
    public static void main(String[] args)
    {
        new Thread(new Counter()).start();
    }
}
class Counter implements Runnable{
    private int count = 10;
    @Override
    public void run()
    {
        synchronized (this){
            for (int i = count;i > 0; i--)
            {

                System.out.println(i);
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Happy new year!");
        }
    }
}