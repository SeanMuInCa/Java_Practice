package mashibing.sync_morePmoreC;

/**
 * Purpose:             mashibing.sync<br />
 * Data Submitted:      2023/11/30 <br />
 * Assignment Number:    mashibing.sync<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          mashibing.sync <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestProductAndConsume
{
    public static void main(String[] args)
    {
        Production p = new Production();

        ProducerThread pt = new ProducerThread(p);
        ProducerThread pt2 = new ProducerThread(p);
        ProducerThread pt3 = new ProducerThread(p);

        Consumer ct = new Consumer(p);
        Consumer ct2 = new Consumer(p);
        Consumer ct3 = new Consumer(p);

        pt.start();
        pt2.start();
        pt3.start();
        ct.start();
        ct2.start();
        ct3.start();
    }
}
