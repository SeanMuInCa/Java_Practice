package TestThreadTextBook;


import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
public class ConsumerProducer
{
    private static Buffer buffer = new Buffer();

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
                    buffer.write(i++);
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException e)
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
                    System.out.println("\t\tConsumer reads " + buffer.read());
                    Thread.sleep((int) (Math.random() * 10000));
                }
            }catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    private static class Buffer
    {
        private static final int CAPACITY = 1;
        private LinkedList<Integer> queue = new LinkedList<>();
        private static Lock lock = new ReentrantLock();
        private static Condition notEmpty = lock.newCondition();
        private static Condition notFull = lock.newCondition();
    }
}
