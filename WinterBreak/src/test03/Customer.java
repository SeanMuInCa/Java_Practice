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
public class Customer
{
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account acct)
    {
        this.account = acct;
    }

    @Override
    public String toString()
    {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account=" + account +
                '}';
    }
}
