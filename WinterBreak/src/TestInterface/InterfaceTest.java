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
public class InterfaceTest
{
    public static void main(String[] args)
    {
        Bullet bullet = new Bullet();
        bullet.attack();
        bullet.fly();
    }
}
interface Flyable
{
    public static final int MIN_SPEED = 10;
    int MAX_SPEED = 7900;

    public void fly();
}
interface Attackable
{
    public void attack();
}
class Plane implements Flyable
{
    public void fly()
    {
        System.out.println("Plane is flying");
    }

}

class Bullet implements Attackable, Flyable
{
    public void attack()
    {
        System.out.println("Bullet is attacking");
    }

    @Override
    public void fly()
    {
        System.out.println("Bullet is flying");
    }
}