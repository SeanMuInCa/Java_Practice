package Test06;

public class BankTest
{
    public static void main(String[] args)
    {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1==bank2);
    }
}
