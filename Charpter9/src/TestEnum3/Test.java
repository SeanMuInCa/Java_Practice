package TestEnum3;

/**
 * Purpose:             TestEnum3<br />
 * Data Submitted:      2023/12/2 <br />
 * Assignment Number:    TestEnum3<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestEnum3 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Test
{
    public static void main(String[] args)
    {
        Person p = new Person();
        p.setAge(14);
        p.setName("raina");
        p.setSex(Sex.FEMALE);
        System.out.println(p);
    }
}
