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
public class TestDeadLock
{
    public static void main(String[] args)
    {
        DeadLock t1 = new DeadLock(false);
        DeadLock t2 = new DeadLock(true);
        t1.start();
        t2.start();
    }
}
class DeadLock extends Thread
{
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;
    public DeadLock(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public void run()
    {
        if(flag)//典型死锁，各不相让
        {
            synchronized (o1)
            {
                System.out.println(Thread.currentThread().getName() + " o1");
                System.out.println(Thread.currentThread().getState());
                synchronized (o2)
                {
                    System.out.println(Thread.currentThread().getName() + " o2");
                }
            }
        }else {
            synchronized (o2)
            {
                System.out.println(Thread.currentThread().getName() + " o2 in else");
                System.out.println(Thread.currentThread().getState());
                synchronized (o1)
                {
                    System.out.println(Thread.currentThread().getName() + " o1 in else");
                }
            }
        }
    }
}