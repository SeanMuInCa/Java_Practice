package TestThread;

/**
 * Purpose:             TestThread<br />
 * Data Submitted:      2024/3/5 <br />
 * Assignment Number:    TestThread<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TextBook
{
    public static void main(String[] args)
    {
        Runnable a = new PrintChar('a',1000);
        Runnable b = new PrintChar('b',100);
        Runnable c = new PrintNum(100);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(c);

        t1.start();
        t2.start();
        t3.start();
    }
}
class PrintChar implements Runnable{
    private char charToPrint;
    private int times;

    public PrintChar(char charToPrint, int times)
    {
        this.charToPrint = charToPrint;
        this.times = times;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < times; i++)
        {
            System.out.print(charToPrint);
        }
    }
}
class PrintNum implements Runnable{
    private int lastNum;

    public PrintNum(int lastNum)
    {
        this.lastNum = lastNum;
    }

    @Override
    public void run()
    {
        Thread t4 = new Thread(new PrintChar('c',40));
        t4.start();
        try
        {
            for (int i = 1; i <= lastNum; i++)
            {
                System.out.print(" " + i);
                if(i == 50) t4.join();
                //Thread.yield();
            }
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
