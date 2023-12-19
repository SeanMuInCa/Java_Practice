package TestComparable;

import org.junit.Test;

import java.util.Arrays;

/**
 * Purpose:             TestComparable<br />
 * Data Submitted:      2023/12/19 <br />
 * Assignment Number:    TestComparable<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestComparable <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TestComparable
{
    @Test
    public void test()
    {
        Product[] products = new Product[5];
        products[0] = new Product("pen", 11.0);
        products[1] = new Product("toy", 6.5);
        products[2] = new Product("cola", 3.0);
        products[3] = new Product("laptop", 11.0);
        products[4] = new Product("monitor", 500.0);

        Arrays.sort(products);//报错，无法比较
        for (Product product : products)
        {
            System.out.println(product);
        }
    }
}

class Product implements Comparable<Product>
{
    private String name;
    private double price;

    public Product()
    {
    }

    public Product(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product p)
    {
//        return name.compareTo(p.name);
        int value = Double.compare(price, p.price);
        value = value == 0? name.compareTo(p.name) : value;
        return value;
    }
}