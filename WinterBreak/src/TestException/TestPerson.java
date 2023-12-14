package TestException;

/**
 * Purpose:             TestException<br />
 * Data Submitted:      2023/12/14 <br />
 * Assignment Number:    TestException<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestException <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestPerson
{
    public static void main(String[] args)
    {
        Person p1 = new Person(20,"Zhenghua Mu");
        Person p2 = new Person();
        p2.setName("zs");
        p2.setLifeValue(-20);
        System.out.println(p1);
        System.out.println(p2);
    }
}
