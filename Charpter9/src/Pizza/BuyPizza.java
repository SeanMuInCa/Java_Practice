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
public class BuyPizza
{
    public static void main(String[] args)
    {
        System.out.println("What kind of pizza you want to order:  ");
        printMenu();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        Pizza p = PizzaProducer.createPizza(choice);
        p.showInfo();
    }

    private static void printMenu()
    {
        System.out.println("\t 1. Bacon  ");
        System.out.println("\t 2. Fruits  ");
    }

}
