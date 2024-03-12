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
public class EatBun
{
    public static void main(String[] args)
    {
        Bun b = new Bun();
        new Thread(new Make(b)).start();
        new Thread(new Eat(b)).start();
    }
}

class Bun
{
    static int num = 0;
    static int max = 10;

    public void eat() throws InterruptedException
    {
        synchronized (this)
        {
            if(num <= 0)
            {
                wait();
            }else
            {
                System.out.println("eat " + num + "th bun");
                num--;
                notify();
            }
        }
    }

    public void make()
    {
        synchronized (this)
        {
            if(num < max)
            {
                num++;
                System.out.println("make one more,we have " + num + " buns");
                notify();
            }else
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
    }
}
class Eat implements Runnable
{
    Bun bun;

    public Eat(Bun bun)
    {
        this.bun = bun;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                bun.eat();
                Thread.sleep(400);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
class Make implements Runnable
{
    Bun bun;

    public Make(Bun bun)
    {
        this.bun = bun;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                bun.make();
                Thread.sleep(400);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}