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
public class TestVehicle
{
    public static void main(String[] args)
    {
        Vehicle v1 = new Bicycle("giant", "red");
        Vehicle v2 = new Car("toyota", "white", "123456");
        Vehicle v3 = new ElectricVehicle("tesla", "blue");
        Developer d1 = new Developer("zhenghua", 40);
        Vehicle[] vehicles = {v1, v2, v3};
        for (Vehicle v : vehicles)
        {
            d1.takingVehicle(v);
            if(v instanceof IPower){//判断接口实例
                ((IPower) v).power();
            }
        }
    }
}
