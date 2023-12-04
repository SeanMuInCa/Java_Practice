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
public class ProducerThread extends Thread   //生产者线程
{
    //共享商品
    private final Production p;

    public ProducerThread(Production p)
    {
        this.p = p;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            if(i % 2 == 0){
                p.product("品牌A","商品1");
            }else{
                p.product("品牌B","商品2");
            }
        }
    }
}
