package mashibing.duoxiancheng1;

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
        //模拟三个窗口抢票
        BuyTicketsThread t1 = new BuyTicketsThread("no.1 ");
        BuyTicketsThread t2 = new BuyTicketsThread("no.2 ");
        BuyTicketsThread t3 = new BuyTicketsThread("no.3 ");
        t1.start();
        t2.start();
        t3.start();
    }
}
