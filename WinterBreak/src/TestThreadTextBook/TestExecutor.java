package TestThreadTextBook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Purpose:             TestThreadTextBook<br />
 * Data Submitted:      2024/3/5 <br />
 * Assignment Number:    TestThreadTextBook<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThreadTextBook <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestExecutor
{
    public static void main(String[] args)
    {
        //create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new PrintChar('a',100));
        executor.execute(new PrintChar('b',100));
        executor.execute(new PrintChar('c',100));
//        executor.execute(new PrintNum(100));

        executor.shutdown();
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
                if(i == 20) t4.join();
                //Thread.yield();
            }
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}