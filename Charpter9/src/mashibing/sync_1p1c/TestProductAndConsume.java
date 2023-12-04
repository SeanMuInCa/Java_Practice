package mashibing.sync_1p1c;

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

        Consumer ct = new Consumer(p);

        pt.start();
        ct.start();
    }
}
