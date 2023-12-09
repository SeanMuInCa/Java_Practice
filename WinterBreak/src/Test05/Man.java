package Test05;

/**
 * Purpose:             Test05<br />
 * Data Submitted:      2023/12/9 <br />
 * Assignment Number:    Test05<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Test05 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Man extends Person
{
    public void smoke(){
        System.out.println("smoke --- man");
    }

    @Override
    public void eat()
    {
        System.out.println("eat---man");
    }

    @Override
    public void toilet()
    {
        System.out.println("shit---man");
    }
}
