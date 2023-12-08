package Test04;

/**
 * Purpose:             Test04<br />
 * Data Submitted:      2023/12/8 <br />
 * Assignment Number:    Test04<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Test04 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestAccount
{
    public static void main(String[] args)
    {
        Account acc = new Account(1122,20000,0.045);
        System.out.println(acc.getMonthlyInterest());
        acc.deposit(1000);
        acc.withdraw(2000);
        acc.withdraw(19001);

        CheckAccount c = new CheckAccount(1123,200,0.045,1000);
        c.withdraw(300);
        System.out.println(c.getBalance());
        System.out.println(c.getOverdraft());
        /*c.withdraw(200);
        System.out.println(c.getBalance());
        c.withdraw(200);
        System.out.println(c.getBalance());
        c.withdraw(1701);
        System.out.println(c.getBalance());*/
    }
}
