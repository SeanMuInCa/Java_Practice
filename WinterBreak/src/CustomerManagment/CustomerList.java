package CustomerManagment;

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
public class CustomerList
{
    private Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomer)
    {
        customers = new Customer[totalCustomer];
    }

    public int getTotal()
    {
        return total;
    }
    public boolean addCustomer(Customer customer){
        if(customers.length == total) return false;
        for (int i = 0; i < total; i++)
        {
            if(customers[i].getPhone().equals(customer.getPhone()) || customers[i].getEmail().equals(customer.getEmail())){
                System.out.println("We already have the same phone number or email address");
                return false;
            }
        }
        if(total < customers.length){
            customers[total++] = customer;
        }/*else{
            System.out.println("wait a second");
            Customer[] cs = new Customer[total + 10];
            System.arraycopy(customers,0,cs,0,customers.length);
            this.customers = cs;
        }*/
        return true;
    }
    public boolean replaceCustomer(int index, Customer customer){
        if(((index - 1) < 0) || (index >= total)){
            return false;
        }
        customers[index - 1] = customer;
        return true;
    }
    public boolean deleteCustomer(int index){
        if(((index - 1) < 0) || (index >= total)){
            return false;
        }
        for (int i = index - 1; i < total - 1; i++)
        {
            customers[i] = customers[i + 1];
        }
        customers[total - 1] = null;
        total--;
        return true;
    }
    public Customer[] getAllCustomers(){
        Customer[] cs = new Customer[total];
        System.arraycopy(customers, 0, cs, 0, total);
        return cs;
    }
    public Customer getCustomer(int index){
        return customers[index - 1];
    }
}
