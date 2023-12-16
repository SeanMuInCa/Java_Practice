package TestThread1;

/**
 * Purpose:             TestThread1<br />
 * Data Submitted:      2023/12/15 <br />
 * Assignment Number:    TestThread1<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Tickets2
{
    public static void main(String[] args)
    {
        Sale1 t1 = new Sale1();
        Sale1 t2 = new Sale1();
        Sale1 t3 = new Sale1();
        t1.start();
        t2.start();
        t3.start();

    }
}
class Sale1 extends Thread{
    static int tickets = 100;
    @Override
    public void run()
    {
        while (tickets > 0){
            System.out.println(Thread.currentThread().getName() + " " + tickets--);
        }
    }
}
