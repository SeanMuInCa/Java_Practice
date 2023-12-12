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
public class Developer
{
    private String name;
    private int age;

    public Developer()
    {
    }

    public Developer(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void takingVehicle(Vehicle vehicle)
    {
        vehicle.run();
    }
}
