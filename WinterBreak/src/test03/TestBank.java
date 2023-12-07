package test03;

/**
 * Purpose:             test03<br />
 * Data Submitted:      2023/12/6 <br />
 * Assignment Number:    test03<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          test03 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestBank
{
    public static void main(String[] args)
    {
        Bank b = new Bank();
        for (int i = 0; i < 11; i++)
        {
            b.addCustomer("raina" + i, "mu" + i);
        }
        System.out.println(b.getNumberOfCustomer());
        System.out.println(b.getCustomer(11));
        b.getCustomer(0).setAccount(new Account(1000));
        b.getCustomer(0).getAccount().withdraw(100);
        System.out.println(b.getCustomer(0).getAccount().getBalance());
    }
}
