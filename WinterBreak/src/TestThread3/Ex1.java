package TestThread3;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Purpose:             TestThread3<br />
 * Data Submitted:      2024/2/19 <br />
 * Assignment Number:    TestThread3<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Ex1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        AtomicBoolean flag = new AtomicBoolean(true);
        Runnable t1 = ()->{
            while (flag.get())
            {
                System.out.println(generateNum());
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable t2 = ()->{
            String str = input.next();
            if("q".equalsIgnoreCase(str))
            {
                System.out.println("ok");
                flag.set(false);
            }
        };
        new Thread(t1).start();
        new Thread(t2).start();
    }

    private static int generateNum()
    {
        return ((int)(Math.random() * 100) + 1);
    }
}

