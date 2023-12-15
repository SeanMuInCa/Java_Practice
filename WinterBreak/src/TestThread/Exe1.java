package TestThread;

/**
 * Purpose:             TestThread<br />
 * Data Submitted:      2023/12/15 <br />
 * Assignment Number:    TestThread<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Exe1
{
    public static void main(String[] args)
    {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        t1.start();
        t2.start();
    }
}
class Thread1 extends Thread
{
    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+" " + i);
            }
        }
    }
}

