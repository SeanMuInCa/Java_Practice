import java.util.Scanner;

public class Hex2Dec
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = input.next().toUpperCase();
        int dec = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            dec += countHex(c) * Math.pow(16, str.length() - 1 - i);
        }
        System.out.print(dec);
    }

    public static int countHex(char c)
    {
        return (c <= 'F' && c >= 'A') ? 10 + c - 'A' : c - '0';
    }

}
