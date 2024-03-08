package TestThreadTextBook;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class AccountWithoutSync
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
            System.out.println("Balance? " + account.getBalance());
        }
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
        private int balance = 0;
        public int getBalance(){
            return balance;
        }
        public synchronized void deposit(int amount)
        {
            int newBalance = balance + amount;//this is the problem
            try
            {
                Thread.sleep(5);
            }catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
            balance = newBalance;
        }
    }
//    private static class Account
//    {
//        private static Semaphore semaphore = new Semaphore(1);//效率超级低
//        private int balance = 0;
//        public int getBalance()
//        {
//            return balance;
//        }
//        public void deposit(int amount)
//        {
//            try
//            {
//                semaphore.acquire();
//                int newBalance = balance + amount;
//                Thread.sleep(500);
//                balance = newBalance;
//            }catch (InterruptedException e)
//            {
//                System.out.println(e.getMessage());
//            }finally
//            {
//                semaphore.release();
//            }
//        }
//    }
}
