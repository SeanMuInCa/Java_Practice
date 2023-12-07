package test03;

/**
 * Purpose:             test03<br />
 * Data Submitted:      2023/12/6 <br />
 * Assignment Number:    test03<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          test03 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Bank
{
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank()
    {
        customers = new Customer[numberOfCustomer + 10];
    }
    public void addCustomer(String f, String l){
        Customer c = new Customer(f,l);
        if(numberOfCustomer < customers.length){
            customers[numberOfCustomer++] = c;
        }else{
            System.out.println("wait a second");
            Customer[] cs = new Customer[numberOfCustomer + 10];
            System.arraycopy(customers,0,cs,0,customers.length);
            customers = cs;
        }
    }
    public int getNumberOfCustomer(){
        return numberOfCustomer;
    }
    public Customer getCustomer(int index){
        return customers[index];
    }

}
