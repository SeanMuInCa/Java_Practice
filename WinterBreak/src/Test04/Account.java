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
public class Account
{
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate)
    {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId()
    {
        return id;
    }

    public double getBalance()
    {
        return balance;
    }

    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    public void setId(int id)
    {
        this.id = id;
    }

//    public void setBalance(double balance)
//    {
//        this.balance = balance;
//    }

    public void setAnnualInterestRate(double annualInterestRate)
    {
        this.annualInterestRate = annualInterestRate;
    }
    public double getMonthlyInterest(){
        return annualInterestRate / 12;
    }
    public void withdraw(double amount){
        if(this.getBalance() >= amount){
            System.out.println("withdraw works");
            this.balance-= amount;
            System.out.println("your new balance is: " + this.getBalance());
        }else{
            System.out.println("not enough balance!");
            System.out.println("your balance is: " + this.getBalance());
            System.out.println("your monthly Interest is: " + this.getMonthlyInterest());
        }
    }
    public void deposit(double amount){
        System.out.println("deposit works");
        this.balance += amount;
        System.out.println("your new balance is: " + this.getBalance());
    }
}
