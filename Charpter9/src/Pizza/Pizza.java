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
public abstract class Pizza
{
    private String name;
    private int size;
    private double price;

    public String getName()
    {
        return name;
    }

    public int getSize()
    {
        return size;
    }

    public double getPrice()
    {
        return price;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSize(int size)
    {
        this.size = Math.max(Math.min(size, 12), 6);
    }

    public void setPrice(double price)
    {
        this.price = Math.max(76,price);
    }

    public Pizza()
    {
    }

    public Pizza(String name, int size, double price)
    {
        this.name = name;
        setSize(size);
        setPrice(price);
    }

    public abstract void showInfo();

    @Override
    public String toString()
    {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
