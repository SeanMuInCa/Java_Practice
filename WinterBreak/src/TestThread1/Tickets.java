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
public class Tickets
{
    public static void main(String[] args)
    {
        Sale t1 = new Sale();
        Sale t2 = new Sale();
        Sale t3 = new Sale();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}
class Sale implements Runnable{
    static int tickets = 10;
    public void run()
    {
        while (tickets > 0){
            System.out.println(Thread.currentThread().getName() + " got " + tickets--);
        }
    }
}