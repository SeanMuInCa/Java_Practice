import java.util.Scanner;

public class Q8re
{
    public static void main(String[] args)
    {

        //Create a Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        System.out.println("The number " + number + " is" + (isPallyPrime(number) ? " " : " not ") + "a palindrome prime");
    }

    public static boolean isPallyPrime(int number)
    {
        if(!isPrime(number)) return false;
        String numberAsString = number + "";
        String newNumberAsString = reverse(numberAsString);
        return numberAsString.equals(newNumberAsString);
    }

    public static String reverse(String numberAsString)
    {
        String str = "";
        for (int i = numberAsString.length() - 1; i >= 0; i--)
        {
            str += numberAsString.charAt(i);
        }
        return str.trim();
    }

    public static boolean isPrime(long n){
        if (n <= 1) return false;
        for(int i = 2; i < n; ++i)
            if (n % i == 0) return false;
        return true;
    }
}
