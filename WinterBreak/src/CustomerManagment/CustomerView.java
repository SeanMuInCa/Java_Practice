package CustomerManagment;

import java.awt.*;
import java.util.Scanner;

/**
 * Purpose:             CustomerManagment<br />
 * Data Submitted:      2023/12/6 <br />
 * Assignment Number:    CustomerManagment<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          CustomerManagment <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class CustomerView
{
    CustomerList customerList = new CustomerList(10);
    public void startMainMenu(){
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("--------Welcome--------");
            System.out.println("\t1. add new customer");
            System.out.println("\t2. modify a customer");
            System.out.println("\t3. delete a customer");
            System.out.println("\t4. list all customers");
            System.out.println("\t5. exit the system");
            System.out.print("Input your choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 1 -> addNewCustomer();
                case 2 -> modifyCustomer();
                case 3 -> deleteCustomer();
                case 4 -> listAllCustomers();
                case 5 ->{
                    System.out.println("are you sure? y/n");
                    String c = sc.next();
                    if ((c.equals("y") || c.equals("Y")))
                    {
                        System.exit(1);
                    }
                }
                default -> System.out.println("invalid choice");
            }
        }
    }
    private void addNewCustomer(){
        System.out.println("addNewCustomer");
    }
    private void modifyCustomer(){
        System.out.println("modifyCustomer");
    }
    private void deleteCustomer(){
        System.out.println("deleteCustomer");
    }
    private void listAllCustomers(){
        System.out.println("listAllCustomers");
    }

    public static void main(String[] args)
    {
        CustomerView cv = new CustomerView();
        cv.startMainMenu();
    }
}
