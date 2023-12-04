package mashibing.sync_morePmoreC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
public class Production
{
    private String brand;
    private String name;
    boolean flag = false;//是否有商品可消费

    //声明一个锁，这个锁可以实现多生产者，多消费者同步线程
    Lock lock = new ReentrantLock();
    //生产者等待池
    Condition produceCondition = lock.newCondition();
    //消费者等待池
    Condition consumeCondition = lock.newCondition();

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void product(String brand, String name)
    {
        lock.lock();
        try
        {
            if (this.flag)
            {
                try
                {
                    //生产者等待
                    produceCondition.await();
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
            this.setBrand(brand);
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            this.setName(name);
            System.out.println("生产者，生产了" + this.getBrand() + "的----" + this.getName());
            this.flag = true;
//            notify();
            //告知消费者等待池
            consumeCondition.signal();
        } finally
        {
            lock.unlock();
        }
    }

    public void consume()
    {
        lock.lock();
        try {
            if (!this.flag)
            {
                try
                {
//                wait();
                    consumeCondition.await();
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("消费者，消费了" + this.getBrand() + "的---" + this.getName());
            this.flag = false;
//            notify();
            produceCondition.signal();
        }finally
        {
            lock.unlock();
        }
    }
}
