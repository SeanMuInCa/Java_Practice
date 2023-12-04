package mashibing.sync;

/**
 * Purpose:             mashibing.duoxiancheng<br />
 * Data Submitted:      2023/11/26 <br />
 * Assignment Number:    mashibing.duoxiancheng<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.duoxiancheng <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestTickets
{
    public static void main(String[] args)
    {
        //模拟三个窗口抢票  在以前的java版本里，这样写会出现重复的问题，我用的jdk21不会
        BuyTicketsThread t1 = new BuyTicketsThread();
        //可以共享一个线程对象，因为是实现接口方式
        Thread tt1 = new Thread(t1,"no.1 ");
        Thread tt2 = new Thread(t1,"no.2 ");
        Thread tt3 = new Thread(t1,"no.3 ");

        tt1.start();
        tt2.start();
        tt3.start();
    }
}
