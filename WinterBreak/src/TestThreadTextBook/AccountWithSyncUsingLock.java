package TestThreadTextBook;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Purpose:             TestThreadTextBook<br />
 * Data Submitted:      2024/3/6 <br />
 * Assignment Number:    TestThreadTextBook<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          TestThreadTextBook <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class AccountWithSyncUsingLock
{
    private static Account account = new Account();

    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++)
        {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        while (!executor.isTerminated())
        {
//            System.out.println("Balance? " + account.getBalance());
        }
        System.out.println("Balance? " + account.getBalance());
    }
    private static class AddAPennyTask implements Runnable
    {
        @Override
        public void run()
        {
            account.deposit(1);
        }
    }
    private static class Account{
        private static Lock lock = new ReentrantLock();
        private int balance = 0;
        public int getBalance(){
            return balance;
        }
        public void deposit(int amount)
        {
            lock.lock();
            try
            {
//                int newBalance = balance + amount;//this is the problem
//                Thread.sleep(5);
//                balance = newBalance;
                balance += amount;
            } finally
            {
                lock.unlock();
            }

        }
    }
}
