package TestThreadCommicate;

/**
 * Purpose:             TestThreadCommicate<br />
 * Data Submitted:      2023/12/16 <br />
 * Assignment Number:    TestThreadCommicate<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThreadCommicate <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 * 生产者将商品交给店员，消费者从店员那里消费商品，店员最大只能持有20个。当商品满了，就要通知生产者停止生产。
 * 当消费了一个后，就要通知生产者生产。当商品有了，就要通知消费者消费。
 */
public class ProducerConsumer
{
    public static void main(String[] args)
    {
        Shopper shopper = new Shopper();
        Producer p = new Producer(shopper);
        Consumer c = new Consumer(shopper);
        Thread t1 = new Thread(p,"生产者1");
        Thread t2 = new Thread(c,"消费者1");
        Thread t3 = new Thread(c,"消费者2");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Shopper
{
    public static final int holdingMax = 20;
    private int holding;

    public synchronized void add(){
        if(holding >= holdingMax){
            try
            {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }else{
            holding++;
            System.out.println(Thread.currentThread().getName() + "生产了第 " + holding +" 个商品");
            notifyAll();
        }
    }
    public synchronized void minus(){
        if(holding <= 0){
            try
            {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName() + "消费了第 " + holding +" 个商品");
            holding--;
            notifyAll();
        }

    }
}

class Producer implements Runnable
{
    private Shopper shopper;

    public Producer(Shopper shopper)
    {
        this.shopper = shopper;
    }

    @Override
    public void run()
    {
        while (true)
        {
            System.out.println("开始生产...");
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            shopper.add();
        }
    }
}

class Consumer implements Runnable
{
    private Shopper shopper;

    public Consumer(Shopper shopper)
    {
        this.shopper = shopper;
    }

    @Override
    public void run()
    {
        while (true)
        {
            System.out.println("开始消费...");
            try
            {
                Thread.sleep(300);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            shopper.minus();
        }
    }
}