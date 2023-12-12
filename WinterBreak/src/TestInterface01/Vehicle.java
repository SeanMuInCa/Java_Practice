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
public abstract class Vehicle
{
    private String brand;
    private String color;

    public Vehicle()
    {
    }

    public Vehicle(String brand, String color)
    {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }
    public abstract void run();
}
