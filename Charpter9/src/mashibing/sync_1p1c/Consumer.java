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
public class Consumer extends Thread //消费者线程
{
    private final Production p;
    public Consumer(Production p){
        this.p = p;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            p.consume();
        }
    }
}
