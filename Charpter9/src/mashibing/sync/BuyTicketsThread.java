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
public class BuyTicketsThread implements Runnable
{
    int availableTickets = 10;//用实现接口方式，这里就不需要static了

    @Override
    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            synchronized (this){//同步代码块，这样买票的顺序也是固定的了，这个原理相当于加锁
                if(availableTickets > 0){
                    System.out.println("i got the " + availableTickets-- + " ticket from " + Thread.currentThread().getName() + "counter!");
                }//                                  这里，--操作的时候，由于是赋值和减一两个操作，有可能会出现赋值结束后，减一没执行的时候，线程被抢走了
            }
        }
    }
}
