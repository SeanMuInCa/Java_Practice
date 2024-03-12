package TestThreadTextBook;

/**
 * Purpose:             TestThreadTextBook<br />
 * Data Submitted:      2024/3/11 <br />
 * Assignment Number:    TestThreadTextBook<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          TestThreadTextBook <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class BunShop2
{
    private int count;
    private boolean hasLeft;

    public BunShop2()
    {
    }

    public BunShop2(int count, boolean hasLeft)
    {
        this.count = count;
        this.hasLeft = hasLeft;
    }

    public synchronized void getCount()
    {
        while (isHasLeft())
        {
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            System.out.println("we have " + count + " buns left");
            setHasLeft(false);
            notifyAll();
        }

        try
        {
            wait();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }


    }

    public boolean isHasLeft()
    {
        return hasLeft;
    }

    public synchronized void setCount()
    {
        while (!isHasLeft())
        {
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            this.count++;
            System.out.println("we make one more, now we have " + count + " buns");
            setHasLeft(true);
            notifyAll();
        }

        try
        {
            wait();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

    }

    public void setHasLeft(boolean hasLeft)
    {
        this.hasLeft = hasLeft;
    }

    public static void main(String[] args)
    {
        BunShop2 shop = new BunShop2();
        //应对多个线程的情况，首先要notifyAll并且为了让线程每次都判断，需要改成while，以让线程循环进行判断
        new Thread(new Produce2(shop)).start();
        new Thread(new Produce2(shop)).start();
        new Thread(new Consumer2(shop)).start();
        new Thread(new Consumer2(shop)).start();
        new Thread(new Consumer2(shop)).start();
    }
}

class Produce2 implements Runnable
{
    BunShop2 shop;

    public Produce2(BunShop2 shop)
    {
        this.shop = shop;
    }

    @Override
    public void run()
    {
        while (true)
        {
            shop.setCount();
        }
    }
}

class Consumer2 implements Runnable
{
    BunShop2 shop;

    public Consumer2(BunShop2 shop)
    {
        this.shop = shop;
    }

    @Override
    public void run()
    {
        while (true)
        {
            shop.getCount();
        }
    }
}
