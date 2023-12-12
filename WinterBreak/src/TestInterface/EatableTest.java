package TestInterface;

/**
 * Purpose:             TestInterface<br />
 * Data Submitted:      2023/12/11 <br />
 * Assignment Number:    TestInterface<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestInterface <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class EatableTest
{
    public static void main(String[] args)
    {
        Eatable[] eatable = new Eatable[3];
        eatable[0] = new Chinese();
        eatable[1] = new American();
        eatable[2] = new Italian();
        for (int i = 0; i < eatable.length; i++)
        {
            eatable[i].eat();
        }
    }
}
interface Eatable
{
    void eat();
}
class Chinese implements Eatable{
    public void eat()
    {
        System.out.println("Chinese eat");
    }
}
class American implements Eatable{
    public void eat()
    {
        System.out.println("American eat");
    }
}
class Italian implements Eatable{
    public void eat()
    {
        System.out.println("Italian eat");
    }
}
