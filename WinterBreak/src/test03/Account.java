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
public class Account
{
    private double balance;

    public Account(double init_balance)
    {
        this.balance = init_balance;
    }

    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amt){
        if(amt >= 0){
            this.balance += amt;
        } else
        {
            this.withdraw(Math.abs(amt));
        }
    }
    public void withdraw(double amt){
        if(amt >= 0 && this.balance >= amt){
            this.balance -= amt;
        }else if(amt >= 0){
            System.out.println("your balance is not enough");
        }else{
            this.deposit(amt);
        }
    }
}
