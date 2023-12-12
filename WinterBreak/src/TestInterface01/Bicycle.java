package TestInterface01;

/**
 * Purpose:             TestInterface01<br />
 * Data Submitted:      2023/12/12 <br />
 * Assignment Number:    TestInterface01<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestInterface01 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Bicycle extends Vehicle
{
    public Bicycle(String brand, String color)
    {
        super(brand, color);
    }

    @Override
    public void run()
    {
        System.out.println("bicycle running");
    }
}
