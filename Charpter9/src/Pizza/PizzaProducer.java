package Pizza;

import java.util.Scanner;

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
public class PizzaProducer
{
    public static Pizza createPizza(int choice) {
        Pizza p = null;
        switch (choice)
        {
            case 1 ->
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input the grams of Bacon: ");
                double gram = sc.nextDouble();
                System.out.println("Input the size: ");
                int size = sc.nextInt();
                System.out.println("Input the price: ");
                double price = sc.nextDouble();
                p = new BaconPizza("Bacon",size,price,gram);
            }
            case 2 ->
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input the fruits you want: ");
                String fruitName = sc.nextLine();
                System.out.println("Input the size: ");
                int size = sc.nextInt();
                System.out.println("Input the price: ");
                double price = sc.nextDouble();
                p = new FruitPizza("Fruit",size,price,fruitName);
            }
        }
        return p;
    }
}
