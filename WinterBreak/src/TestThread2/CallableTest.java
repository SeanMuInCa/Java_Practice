package TestThread2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Purpose:             TestThread2<br />
 * Data Submitted:      2023/12/17 <br />
 * Assignment Number:    TestThread2<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread2 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class CallableTest
{
    public static void main(String[] args)
    {
        NumThread numThread = new NumThread();
        FutureTask<Object> futureTask = new FutureTask<>(numThread);

        Thread t1 = new Thread(futureTask);
        t1.start();
        try
        {
            Object sum = futureTask.get();//这里不执行完，是不会往下走的,主线程阻塞
            System.out.println("sum= " + sum + "---" + Thread.currentThread().getName());
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
class NumThread implements Callable<Object>{
    @Override
    public Object call() throws Exception
    {
        int sum = 0;
        for (int i = 1; i <= 100 ; i++)
        {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
                sum += i;
            }
            Thread.sleep(10);
        }
        return sum;
    }
}
