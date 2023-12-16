package TestThread1;

/**
 * Purpose:             TestThread1<br />
 * Data Submitted:      2023/12/16 <br />
 * Assignment Number:    TestThread1<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestThread1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Exe2
{
    public static void main(String[] args)
    {
        Account account = new Account();//两个客户公用一个账户

        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);

        new Thread(customer1).start();
        new Thread(customer2).start();
    }
}
class Account {
    private double balance;

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
class Customer implements Runnable{
    Account account;
    public Customer(Account account){
        this.account = account;
    }

    @Override
    public void run()
    {
        synchronized (Customer.class){
            for (int i = 0; i < 3; i++)
            {
                System.out.println(Thread.currentThread().getName() + " saving...");
                account.setBalance(this.account.getBalance() + 1000);
                System.out.println(account.getBalance());
            }
        }
    }
}
