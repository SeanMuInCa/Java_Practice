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
public class Exe2
{
    public static void main(String[] args)
    {
        Thread3 t3 = new Thread3();
        Thread4 t4 = new Thread4();
        t3.start();
        t4.start();
    }
}
class Thread3 extends Thread{
    @Override
    public void run()
    {
        for (int i = 1; i <= 100 ; i++)
        {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}
class Thread4 extends Thread{
    @Override
    public void run()
    {
        for (int i = 1; i <= 100 ; i++)
        {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}
