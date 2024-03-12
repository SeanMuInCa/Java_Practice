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
public class BunShop1
{
    private int count;
    private boolean hasLeft;

    public BunShop1()
    {
    }

    public BunShop1(int count, boolean hasLeft)
    {
        this.count = count;
        this.hasLeft = hasLeft;
    }

    public synchronized void getCount()
    {
        if (isHasLeft())
        {
            System.out.println("we have " + count + " buns left");
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            setHasLeft(false);
            notify();
        } else
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }

    }

    public boolean isHasLeft()
    {
        return hasLeft;
    }

    public synchronized void setCount()
    {
        if (!isHasLeft())
        {
            this.count++;
            System.out.println("we make one more, now we have " + count + " buns");
            setHasLeft(true);
            notify();
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        } else
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public void setHasLeft(boolean hasLeft)
    {
        this.hasLeft = hasLeft;
    }

    public static void main(String[] args)
    {
        BunShop shop = new BunShop();
        new Thread(new Produce(shop)).start();
        new Thread(new Consumer(shop)).start();
    }
}

class Produce1 implements Runnable
{
    BunShop shop;

    public Produce1(BunShop shop)
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

class Consumer1 implements Runnable
{
    BunShop shop;

    public Consumer1(BunShop shop)
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
