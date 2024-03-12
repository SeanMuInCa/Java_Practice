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
public class BunShop
{
    private int count;
    private boolean hasLeft;

    public BunShop()
    {
    }

    public BunShop(int count, boolean hasLeft)
    {
        this.count = count;
        this.hasLeft = hasLeft;
    }

    public void getCount()
    {
        System.out.println("we have " + count + " buns left");
    }

    public boolean isHasLeft()
    {
        return hasLeft;
    }

    public void setCount()
    {
        this.count++;
        System.out.println("we make one more, now we have " + count + " buns");
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

class Produce implements Runnable
{
    BunShop shop;

    public Produce(BunShop shop)
    {
        this.shop = shop;
    }

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (shop)
            {
                if (!shop.isHasLeft())
                {
                    shop.setCount();
                    shop.setHasLeft(true);
                    shop.notify();
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
                        shop.wait();
                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

class Consumer implements Runnable
{
    BunShop shop;

    public Consumer(BunShop shop)
    {
        this.shop = shop;
    }

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (shop)
            {
                if (shop.isHasLeft())
                {
                    shop.getCount();
                    try
                    {
                        Thread.sleep(100);
                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                    shop.setHasLeft(false);
                    shop.notify();
                } else
                {
                    try
                    {
                        shop.wait();
                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
