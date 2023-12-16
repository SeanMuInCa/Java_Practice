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
public class Exe1
{
    public static void main(String[] args)
    {
        Thread1 t1 = new Thread1();
        t1.setName("t1");
        t1.start();

        try
        {
            t1.sleep(1000 * 5);//这里其实是主线程休眠了5秒
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("hello");
    }
}
class Thread1 extends Thread{
    @Override
    public void run()
    {
        for (int i = 0; i < 10000; i++)
        {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}