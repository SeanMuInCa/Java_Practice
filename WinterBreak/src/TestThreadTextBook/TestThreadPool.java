package TestThreadTextBook;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Purpose:             TestThreadTextBook<br />
 * Data Submitted:      2024/3/15 <br />
 * Assignment Number:    TestThreadTextBook<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          TestThreadTextBook <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestThreadPool
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MyRunable());
        executorService.submit(new MyRunable());
        executorService.execute(new MyRunable());
        executorService.submit(new MyCallableTest());
        executorService.shutdown();
    }
}
class MyRunable implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() + "thread running...");
    }
}
class MyCallableTest implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception
    {
        System.out.println(Thread.currentThread().getName() + "return 1");
        return 1;
    }
}