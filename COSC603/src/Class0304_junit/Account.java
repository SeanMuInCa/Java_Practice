package Class0304_junit;

/**
 *
 * Purpose:  This class stores all the information about an account.   Each
 * account is assigned a unique identifier.  A class variable is used to 
 * ensure each account gets a unique id.
 * @author CST Instructor
 */

public class Account
{
    /**
     * Unique identifier for account
     */
    private long accountId;
    /**
     * Balance in account
     */
    private float balance;

    /**
     * Constructor for the Account class.  Throw an exception if 
     * balance specified is negative.   
     * @param balance    Starting balance for account
     * @param acctId    Unique account identifier
     */
    public Account( float balance, long acctId )
    {
        this.accountId = acctId;
        if(balance < 0) throw new IllegalArgumentException("wrong input");
        this.balance = balance;
    }

    /**
     *
     * Purpose: Deposit amount specified into account.   If amount is negative
     * throw an IllegalArgumentException
     * @param amount  Amount to be deposited
     */
    public void deposit( float amount )
    {
    }

    /**
     *
     * Purpose: Get account identifier.
     * @return account identifier
     */

    public long getAccountId()
    {
        return 0;
    }

    /**
     *
     * Purpose:  Get current balance
     * @return balance
     */
    public float getBalance()
    {
        return balance;
    }

    /**
     *
     * Purpose: Withdraw requested amount from the account.  If balance is not
     * sufficient in the account then withdrawal will not occur.
     * @param amount    Amount to withdraw
     * @return true if withdrawal occurred, false otherwise
     */
    public boolean withdraw( float amount )
    {
        return false;
    }

    /**
     *
     * Purpose: Set the balance.   Throw an IllegalArgumentException if new
     * balance is negative
     * @param balance   New balance on acount.
     */
    public void setBalance( float balance )
    {
        if(balance < 0) throw new IllegalArgumentException("wrong input");
        this.balance = balance;
    }
}