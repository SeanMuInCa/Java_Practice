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
public class FruitPizza extends Pizza
{
    private String fruits;

    public String getFruits()
    {
        return fruits;
    }

    public void setFruits(String fruits)
    {
        this.fruits = fruits;
    }

    public FruitPizza()
    {
    }

    public FruitPizza(String name, int size, double price, String fruits)
    {
        super(name, size, price);
        this.fruits = fruits;
    }

    @Override
    public void showInfo()
    {
        System.out.println("Pizza name: " + this.getName());
        System.out.println("Pizza price: " + this.getPrice() +" $");
        System.out.println("Pizza size: " + this.getSize() +" inch");
        System.out.println("Fruits: " + fruits);
    }

    @Override
    public String toString()
    {
        return "FruitPizza{" +
                "fruits='" + fruits + '\'' +
                "} " + super.toString();
    }
}
