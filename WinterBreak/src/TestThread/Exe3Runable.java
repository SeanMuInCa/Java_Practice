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
public class Exe3Runable
{
    public static void main(String[] args)
    {
        Runnable t1 = new Thread5();
        Runnable t2 = new Thread5();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(new Runnable() {
            @Override
            public void run()
            {
                for (int i = 0; i < 100; i++)
                {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }).start();

    }
}
class Thread5 implements Runnable{

    @Override
    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}