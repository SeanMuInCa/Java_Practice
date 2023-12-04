package Lab2;

import java.util.Scanner;

public class Dec2Hex
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("input a number: ");
        int dec = input.nextInt();
        String hex = "";
        while (dec != 0)
        {
//            int last = dec % 16;
//            int first = dec / 16;
//            hex += (char)(first) <=9 && (char)first >=0 ? (char)('0'+first) : (char)(first - 10 + 'A');
            int hexValue = dec % 16;
            char hexDigit = (0 <= hexValue && hexValue <= 9) ? (char) (hexValue + '0') : (char) (hexValue - 10 + 'A');
            hex = hexDigit + hex;
            dec = dec / 16;
        }
        System.out.println(hex);
    }
}
