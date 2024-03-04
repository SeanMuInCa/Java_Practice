package Class0304_junit;
/*
 *  [File header includes information about the file being submitted.]
 *  Date submitted:
 *  Assignment number:
 *  Course name:  COSC 190
 *  Instructors: Andrea Grzesina, Sharon McDonald
 *  File path and name: J:\CST\ACOSC190\
 */


/*
 * Date submitted:
 * Assignment number:
 * Course: COSC 190
 * Instructors: Andrea Grzesina, Sharon McDonald
 * Path:
 */

import static org.junit.Assert.*;

import java.util.Scanner;

import Class0304_junit.Account;
import org.junit.Before;
import org.junit.Test;

/**
 *  Purpose: Starting template for a new program. Replace these comments with
 *  your own. Briefly describe the purpose of the class, how the class is used
 *  in the program and how it interacts with other classes.
 *
 * @author YOUR NAME AND CST NUMBER GO HERE
 */

/**
 * Purpose:
 * @author ins209
 */
public class AccountTest
{
    Account sampleAcct;

    /**
     * Purpose:
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        sampleAcct = new Account( 500, 1234 );
    }

    /**
     * Test method for {@link Account# Account(float)}.
     */
    @Test
    public void testAccount()
    {
        assertEquals( 500f, sampleAcct.getBalance(), .0001 );
        assertEquals( 1234, sampleAcct.getAccountId() );

        //Exception should be thrown if balance is negative
        try
        {
            Account acct = new Account( -5, 23 );
            fail( "Exception not thrown");
        }
        catch( IllegalArgumentException ex )
        {
            //do nothing expected
        }
    }

    /**
     * Test method for {@link Account#deposit(float)}.
     */
    @Test
    public void testDeposit()
    {
        sampleAcct.deposit( 250 );
        assertEquals( 750f, sampleAcct.getBalance(), .0001 );
        // Test exception thrown
        try
        {
            sampleAcct.deposit( -45 );
            //If expection is not thrown then this statement is executed
            fail("Did not throw exception");
        }
        catch( IllegalArgumentException ex )
        {
            //do nothing - expected result
        }
    }

    /**
     * Test method for {@link Account#getAccountId()}.
     */
    @Test
    public void testGetAccountId()
    {
        assertEquals( 1234, sampleAcct.getAccountId() );
    }

    /**
     * Test method for {@link Account#getBalance()}.
     */
    @Test
    public void testGetBalance()
    {
        assertEquals( 500f, sampleAcct.getBalance(), .0001 );
    }

    /**
     * Test method for {@link Account#withdraw(float)}.
     */
    @Test
    public void testWithdraw()
    {
        assertFalse( sampleAcct.withdraw( 501f ) );
        assertTrue( sampleAcct.withdraw(200f ) );
        // can withdraw right to zero
        assertTrue( sampleAcct.withdraw(300f ) );
    }

    /**
     * Test method for {@link Account#setBalance(float)}.
     */
    @Test
    public void testSetBalance()
    {
        sampleAcct.setBalance( 1000 );
        assertEquals( 1000f,sampleAcct.getBalance(), .0001 );
        try
        {
            sampleAcct.setBalance( -1 );
            fail("Didn't throw the exception");
        }
        catch( IllegalArgumentException ex )
        {
            //do nothing - expected
        }
    }

}