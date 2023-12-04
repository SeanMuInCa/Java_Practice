import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.print("How many rows: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++)
        {
            //figure1
            for (int j = 0; j < i + 1; j++)
            {
                System.out.print("*");
            }
            for (int j = 0; j < n; j++)
            {
                System.out.print(" ");
            }
            //figure2
            for (int j = n; j > i; j--)
            {
                System.out.print("*");
            }
            for (int j = 0; j < n; j++)
            {
                System.out.print(" ");
            }
            //figure3
            for (int j = n - i; j > 0; j--)
            {
                System.out.print("*");
            }
            for (int j = 0; j < i + 1; j++)
            {
                System.out.print(" ");
            }
            //figure4
            for (int j = 0; j < n - 1 - i; j++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++)
            {
                System.out.print("*");
            }

            for (int j = 0; j < n; j++)
            {
                System.out.print(" ");
            }

            //figure5
            for (int j = 0; j < n - 1 - i; j++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++)
            {
                System.out.print("*");
            }
            for (int j = 0; j < n - 1 - i; j++)
            {
                System.out.print(" ");
            }
            //blank
//            for (int j = 0; j < n; j++)
//            {
//                System.out.print(" ");
//            }
            //figure6
            for (int j = 0; j < i; j++)
            {
                System.out.print(" ");
            }
            for (int j = 2 * (n - i) - 1; j > 0; j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++)
        {
            System.out.print(6 + i * (i + 1) + " ");
        }
    }
}