package TestThreadTextBook;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Purpose:             TestThreadTextBook<br />
 * Data Submitted:      2024/3/7 <br />
 * Assignment Number:    TestThreadTextBook<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          TestThreadTextBook <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class ConsumerProducerUsingBlockingQueue
{
    private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(1);

    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();
    }
    private static class ProducerTask implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                int i = 1;
                while (true)
                {
                    System.out.println("Producer writes " + i);
                    buffer.put(i++);
                    Thread.sleep((int) (Math.random() * 10000));
                }
            }catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    private static class ConsumerTask implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    System.out.println("\t\t\t\t\t\tConsumer reads " + buffer.take());
                    Thread.sleep((int) (Math.random() * 10000));
                }
            }catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
