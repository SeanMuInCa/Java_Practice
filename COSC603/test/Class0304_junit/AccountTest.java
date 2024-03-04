package Class0304_junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Purpose:             Class0304_junit<br />
 * Data Submitted:      2024/3/4 <br />
 * Assignment Number:    Class0304_junit<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Class0304_junit <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
class AccountTest
{
    Account account;
    @BeforeEach
    void setUp()
    {
        account = new Account(10000,1);
    }
    @Test
    void createAccount()
    {

        assertEquals(10000, account.getBalance());

        IllegalArgumentException th = assertThrows(IllegalArgumentException.class, ()-> {
            account.setBalance(-100);
        });
        assertTrue(th.getMessage().contains("input"));
//        try
//        {
//            account = new Account(-10000,1);
//            fail("can't be negative");
//        }catch (IllegalArgumentException e)
//        {
//            //System.out.println(e.getMessage());
//        }
    }

    @Test
    void deposit()
    {
    }

    @Test
    void getAccountId()
    {
    }

    @Test
    void getBalance()
    {
    }

    @Test
    void withdraw()
    {
    }

    @Test
    void setBalance()
    {
    }
}