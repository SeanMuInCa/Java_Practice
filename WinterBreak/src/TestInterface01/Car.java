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
public class Car extends Vehicle implements IPower
{
    private String carNumber;

    public Car(String brand, String color, String carNumber)
    {
        super(brand, color);
        this.carNumber = carNumber;
    }

    public String getCarNumber()
    {
        return carNumber;
    }

    public void setCarNumber(String carNumber)
    {
        this.carNumber = carNumber;
    }

    @Override
    public void run()
    {
        System.out.println("car running");
    }
    public void power(){
        System.out.println("i need gas");
    }
}
