package TestThreadTextBook;

import java.util.concurrent.*;

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
public class TestThreadPool1
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        Callable<String> c = ()-> "hello world";
        Callable<Integer> c1 = ()-> {
          int sum = 0;
            for (int i = 1; i <= 100; i++)
            {
                sum += i;
            }
            return sum;
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<String> future1 = es.submit(c);
        Future<Integer> future = es.submit(c1);
        System.out.println(future.get());
        System.out.println(future1.get());
        es.shutdown();
    }
}
