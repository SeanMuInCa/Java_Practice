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
public class CheckAccount extends Account
{
    private double overdraft;
    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft)
    {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft()
    {
        return overdraft;
    }

    public void setOverdraft(double overdraft)
    {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount)
    {
        if(this.getBalance() >= amount){
            super.withdraw(amount);
        }else{
            if((amount - this.getBalance()) < overdraft){
                double diff = amount - this.getBalance();
                super.withdraw(this.getBalance());
                this.overdraft -= diff;
            }else{
                System.out.println("you are over your draft");
            }
        }
    }
}
