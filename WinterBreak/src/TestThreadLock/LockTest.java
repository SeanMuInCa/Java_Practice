package TestThreadLock;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Purpose:             TestThreadLock<br />
 * Data Submitted:      2023/12/16 <br />
 * Assignment Number:    TestThreadLock<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThreadLock <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class LockTest
{
    public static void main(String[] args)
    {
        Sale t1 = new Sale();
        Sale t2 = new Sale();
        Sale t3 = new Sale();
        t1.start();
        t2.start();
        t3.start();

    }

}
class Sale extends Thread{
    static int tickets = 10;

    private static final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run()
    {
        while (true){
            lock.lock();
            try
            {
                if(tickets > 0){
                    try
                    {
                        Thread.sleep(100);
                    }catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " " + tickets);
                    tickets--;
                }else{
                    break;
                }
            }finally
            {
                lock.unlock();
            }

        }
    }
}
