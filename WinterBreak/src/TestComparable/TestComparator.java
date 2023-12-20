package TestComparable;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

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
public class TestComparator
{
    @Test
    public void test(){
        Product[] products = new Product[5];
        products[0] = new Product("cola", 11.0);
        products[1] = new Product("toy", 6.5);
        products[2] = new Product("pen", 3.0);
        products[3] = new Product("laptop", 11.0);
        products[4] = new Product("monitor", 500.0);

        myComparator myComparator = new myComparator();

        Arrays.sort(products, myComparator);
        for (Product product : products)
        {
            System.out.println(product);
        }
    }
}
class myComparator implements Comparator<Product>{


    @Override
    public int compare(Product o1, Product o2)
    {
        return o1.getName().compareTo(o2.getName());
    }
}
