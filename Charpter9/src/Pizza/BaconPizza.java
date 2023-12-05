package Pizza;

/**
 * Purpose:             Pizza<br />
 * Data Submitted:      2023/12/4 <br />
 * Assignment Number:    Pizza<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Pizza <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class BaconPizza extends Pizza
{
    private double baconWeight;

    public double getBaconWeight()
    {
        return baconWeight;
    }

    public void setBaconWeight(double baconWeight)
    {
        this.baconWeight = Math.max(baconWeight,0);
    }

    public BaconPizza()
    {
    }

    public BaconPizza(String name, int size, double price, double baconWeight)
    {
        super(name, size, price);
        setBaconWeight(baconWeight);
    }

    @Override
    public void showInfo()
    {
        System.out.println("Pizza name: " + this.getName());
        System.out.println("Pizza price: " + this.getPrice() +" $");
        System.out.println("Pizza size: " + this.getSize() +" inch");
        System.out.println("Bacon: " + this.getBaconWeight() +" g");
    }

    @Override
    public String toString()
    {
        return "BaconPizza{" +
                "baconWeight=" + baconWeight +
                "} " + super.toString();
    }
}
