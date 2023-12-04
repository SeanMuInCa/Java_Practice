package mashibing.sync;

/**
 * Purpose:             mashibing.sync<br />
 * Data Submitted:      2023/11/29 <br />
 * Assignment Number:    mashibing.sync<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.sync <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestTickets2 extends Thread
{
    public static int availableTickets = 10;

    public TestTickets2(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            synchronized (TestTickets2.class)//这个锁，本质上是一个独一无二的即可。一般用类的字节码
            {//同步代码块，这样买票的顺序也是固定的了，这个原理相当于加锁
                if (availableTickets > 0)
                {
                    System.out.println("i got the " + availableTickets-- + " ticket from " + Thread.currentThread().getName() + "counter!");
                }//                                  这里，--操作的时候，由于是赋值和减一两个操作，有可能会出现赋值结束后，减一没执行的时候，线程被抢走了
            }
        }
    }
}

class Test
{
    public static void main(String[] args)
    {
        TestTickets2 t1 = new TestTickets2("no.1");
        TestTickets2 t2 = new TestTickets2("no.2");
        TestTickets2 t3 = new TestTickets2("no.3");
        t1.start();
        t2.start();
        t3.start();
    }
}